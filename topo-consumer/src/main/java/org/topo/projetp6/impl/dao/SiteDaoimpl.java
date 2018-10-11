package org.topo.projetp6.impl.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bean.topo.projetp6.Secteur;
import org.bean.topo.projetp6.Site;
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

    //  List <Secteur> secteurs=secteurDAO.affiche(idtopo);

        System.out.println("valeur de vlistsite" + vlistesite);


        return vlistesite;
    }

    @Override
    public void miseajour(Site site) {

    }

    @Override
    public Site ajoutopo(Site site) {
        return null;
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

        // String vSQL = "SELECT * FROM public.site ";
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
vJdbcTemplate.update(vSQL);
        return null;
    }
}
