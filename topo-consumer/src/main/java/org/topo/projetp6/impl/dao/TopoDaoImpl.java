package org.topo.projetp6.impl.dao;

import org.bean.topo.projetp6.Site;
import org.bean.topo.projetp6.Topo;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.topo.projetp6.impl.dao.mapper.MapperTopo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Array;
import java.util.List;

@Named
public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {

    @Inject
    private TopoDao topoDao;

    @Inject
    private SiteDao siteDao;


    private static final Logger LOGGER=(Logger) LogManager.getLogger(TopoDaoImpl.class);

    @Override
    public List<Topo> affiche() {

        //requete SQL dans bd pour recupperer liste topo
        String vSQL = "SELECT * FROM public.topo";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());

        RowMapper<Topo> montops = new MapperTopo(this.siteDao);
       List<Topo> vListStatut = vJdbcTemplate.query(vSQL, montops);


        return vListStatut;
    }

    @Override
    public Topo getbyiD(int Id) {


        //creation d'une requete avec pour resultat un parametre iD
        String vSQL = "SELECT * FROM public.topo where id= ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());


        RowMapper<Topo> montops = new MapperTopo(this.siteDao);

        Topo topo = vJdbcTemplate.queryForObject(vSQL, montops, Id);
        LOGGER.info("recherche de la liste de topo ");
        return topo;


    }




    @Override
    public void miseajour(final Topo topo) {

        String requetemaj = "UPDATE public.topo SET " +
                "nom = :Nom, \n" +
                "description_topo = :descriptiondestopo, \n" +
                "historique_topo = :historiquedestopo, \n" +
                "hauteur_global = :hauteurDuTopo, \n" +
                "type_roche  = :typeDeroche, \n" +
                "nombre_voie = :nombreDevoie, \n" +
                "description_du_retour = :descriptionDuRetour, \n" +
                "type_equipement = :typeDequipement, \n" +
                "photo_topo = :photoDuTopo" +
                " WHERE id = :iD";




        SqlParameterSource vParams = new BeanPropertySqlParameterSource(topo);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDatasource());
        int vNbrLigneMaJ = vJdbcTemplate.update(requetemaj, vParams);

     /**
        LOGGER.debug("Entrée dans la méthode update");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDatasource());
        jdbcTemplate.update("UPDATE topo SET (nom, description_topo, historique_topo, hauteur_global," +
                        "type_roche,nombre_voie,description_du_retour,type_equipement,photo_topo) = (?,?,?,?,?,?,?,?,?) WHERE id = ? ;",
                topo.getNom(),
                topo.getDescriptiondestopo(),
                topo.getHistoriquedestopo(),
                topo.getHauteurDuTopo(),
                topo.getTypeDeroche(),
                topo.getNombreDevoie(),
                topo.getDescriptionDuRetour(),
                topo.getTypeDequipement(),
                topo.getPhotoDuTopo(),
                topo.getiD()

        );
    */
    }


    /**
     * creation d'un nouveau topo
     *
     * @param topo
     */

    @Override
    public Topo ajoutopo(final Topo topo) {

        String ajoutsql = "INSERT INTO public.topo" +
                " (nom,\n " +
                " description_topo,\n " +
                " historique_topo,\n " +
                " hauteur_global,\n " +
                " type_roche,\n " +
                " nombre_voie,\n " +
                " description_du_retour,\n" +
                " type_equipement,\n" +
                " photo_topo)" +
                "VALUES" +
                "(:nom,:descriptionDutopo,:historiquedestopo,:hauteurDutopo,:typeDeroche,:nombreDevoie,:descriptionDuretour," +
                ":typeDequipement,:photoDuTopo)";

        SqlParameterSource ajoutparam = new MapSqlParameterSource()
                .addValue("nom", topo.getNom())
                .addValue("descriptionDutopo", topo.getDescriptiondestopo())
                .addValue("historiquedestopo", topo.getHistoriquedestopo())
                .addValue("hauteurDutopo", topo.getHauteurDuTopo())
                .addValue("typeDeroche", topo.getTypeDeroche())
                .addValue("nombreDevoie", topo.getNombreDevoie())
                .addValue("descriptionDuretour", topo.getDescriptionDuRetour())
                .addValue("typeDequipement", topo.getTypeDequipement())
                .addValue("photoDuTopo", topo.getPhotoDuTopo());


        //Gestion de la clé primaire
        KeyHolder holder = new GeneratedKeyHolder();
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDatasource());
        vJdbcTemplate.update(ajoutsql, ajoutparam, holder, new String[]{"id"});
        topo.setiD(holder.getKey().intValue());

        return topo;

    }

    public Topo supprimetopo(int Id) {
        LOGGER.info("suppression d'un topo");
        String vSQL = "DELETE FROM public.topo where id= ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());

    //    RowMapper<Topo> montops = new MapperTopo(this.siteDao);

     //   Topo tops = vJdbcTemplate.queryForObject(vSQL, montops,Id);
vJdbcTemplate.update(vSQL,Id);

//vJdbcTemplate.update("delete from topo where id = ?",Id);
        return null;
    }



    public Topo find(Integer id) {
        String vsql ="SELECT * FROM public.topo WHERE id=?";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());
        Topo tops=(Topo) vJdbcTemplate.queryForObject(vsql, new Object[] { id }, new MapperTopo(siteDao));
        if(tops==null) {
            return null;
        }
        return tops;
    }

}









