package org.topo.projetp6.impl.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bean.topo.projetp6.Secteur;
import org.bean.topo.projetp6.Site;
import org.bean.topo.projetp6.Topo;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.topo.projetp6.impl.DaoFactory;
import org.topo.projetp6.impl.dao.mapper.MapperSite;

@Named
public class SiteDaoimpl extends AbstractDaoImpl implements SiteDao {
    private static final Logger LOGGER=(Logger) LogManager.getLogger(TopoDaoImpl.class);

    @Inject
    private SiteDao siteDao;

    @Inject
    private TopoDao topoDao;

    @Inject
    SecteurDAO secteurDAO;



  //  @Autowired
   // JdbcTemplate jdbcTemplate;


    @Override
    public List<Site> affiche(int idtopo) {
        //requete SQL dans bd pour recupperer liste des sites
        String vSQL = "SELECT * FROM public.site where topoid= ?";
      // String vSQL = "SELECT * FROM public.site ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());

        RowMapper<Site> monmapsite = new MapperSite(this.secteurDAO);
          List<Site> vlistesite = vJdbcTemplate.query(vSQL, monmapsite, idtopo);




        return vlistesite;
    }

    @Override
    public void miseajour(Site site) {

    }

    @Override
    public Site ajoutesite(Site site,Integer idtopo) {

      String ajoutsql = "INSERT INTO public.site " +
                " (identifiant,\n " +
                " nom,\n " +
                " coordonnees_gps" +
               ",\n " +
              " topoid) " +
                "VALUES" +
                "(:identifiant,:nom,:coordonneesGps,:topoid)";

        SqlParameterSource ajoutparam = new MapSqlParameterSource()
                .addValue("identifiant", site.getIdentifiant())
                .addValue("nom", site.getNom())
                .addValue("coordonneesGps", site.getCoordonneesGps())
            .addValue("topoid",site.getiD());

        //Gestion de la clé primaire
        KeyHolder holder = new GeneratedKeyHolder();
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDatasource());
        vJdbcTemplate.update(ajoutsql, ajoutparam, holder, new String[]{"id"});
        site.setiD(holder.getKey().intValue());


/**
           String vsql = "INSERT INTO public.site (id,identifiant,nom,coordonnees_gps,topoid) VALUES (DEFAULT ,?,?,?,?)";
           JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());
           System.out.println("valeur de id  =" + site.getiD());
           vJdbcTemplate.update(vsql,site.getIdentifiant(),site.getNom(),site.getCoordonneesGps(),site.getiD());
*/
/**
        String vSQL = "INSERT INTO site (identifiant, nom, coordonnees_gps,topoid) VALUES (:identifiant,:nom,:coordonnees,:idtopo)";
        //String vSQL = "INSERT INTO site_escalade (nom_site, id_topo, description) VALUES ('"+ name +"',"+ id_topo +",'"+ description +"')";
        MapSqlParameterSource vParams = new MapSqlParameterSource();

        vParams.addValue("identifiant", site.getIdentifiant(), Types.VARCHAR);
        vParams.addValue("nom",site.getNom() , Types.VARCHAR);
        vParams.addValue("id_topo", idtopo, Types.INTEGER);
        vParams.addValue("coordonnees", site.getCoordonneesGps(), Types.VARCHAR);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDatasource());

        try {
            vJdbcTemplate.update(vSQL, vParams);
            System.out.println("Le site "+ site+" est bien ajouté !");
        } catch (Exception e) {
            System.out.println("Le site "+ site +" existe déjà !");
        }
 */
        return site;


    }

    @Override
    public Site getbyiD(int Id) {
        //creation d'une requete avec pour resultat un parametre iD
        String vSQL = "SELECT * FROM public.site where id= ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());
        // String vSQL = "SELECT * FROM public.site ";


       RowMapper<Site>  monmapsite = new MapperSite(this.secteurDAO);


       Site site = vJdbcTemplate.queryForObject(vSQL, monmapsite, Id);
       List<Secteur> secteurs = secteurDAO.affiche(Id);
        System.out.println("dans la dao " + secteurs.toString());
       site.setSecteurs(secteurs);

        return site;
    }



    @Override
    public List<Site> recherche(int Id ){
        String vsql ="SELECT * FROM public.site WHERE topoid= ?";
        //requete SQL dans bd pour recupperer liste des sites

      //  String vsql = "SELECT * FROM public.site ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());


        RowMapper<Site>  monmapsite = new MapperSite(this.secteurDAO);


        List<Site> vlistesite = vJdbcTemplate.query(vsql, monmapsite,Id);

        return vlistesite;
    }



    @Override
    public Site supprimesite(int Id) {
        LOGGER.info("suppression d'un site");
        String vSQL = "DELETE FROM public.site where id= ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());
vJdbcTemplate.update(vSQL,Id);
        return null;
    }
}
