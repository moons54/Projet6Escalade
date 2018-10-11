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
        System.out.println("valeur de vlist" + vListStatut);

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
                "description_topo = :descriptionDestopo, \n" +
                "historique_topo = :Historiquedestopo, \n" +
                "hauteur_global = :HauteurDuTopo, \n" +
                "type_roche  = :TypeDeroche, \n" +
                "nombre_voie = :NombreDevoie, \n" +
                "description_du_retour = :DescriptionDuRetour, \n" +
                "type_equipement = :TypeDequipement, \n" +
                "photo_topo = :photoDutopo" +
                " WHERE id = :id";

        SqlParameterSource vParams = new BeanPropertySqlParameterSource(topo);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDatasource());
        int vNbrLigneMaJ = vJdbcTemplate.update(requetemaj, vParams);

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
}









