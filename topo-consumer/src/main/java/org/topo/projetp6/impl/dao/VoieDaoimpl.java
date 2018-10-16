package org.topo.projetp6.impl.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bean.topo.projetp6.Secteur;
import org.bean.topo.projetp6.Site;
import org.bean.topo.projetp6.Voie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.topo.projetp6.impl.dao.mapper.MapperSecteur;
import org.topo.projetp6.impl.dao.mapper.MapperVoie;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class VoieDaoimpl extends AbstractDaoImpl implements VoieDao  {
    private static final Logger LOGGER=(Logger) LogManager.getLogger(VoieDaoimpl.class);

   // @Inject
   // VoieDAO VoieDAO;



    @Override
    public List<Voie> affiche(int idsecteur) {
        //requete SQL dans bd pour recupperer liste des sites
        String vSQL = "SELECT * FROM public.voie where secteurid= ?";
       // String vSQL = "SELECT * FROM public.voie";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());

        MapperVoie monmapvoie = new MapperVoie();
        
        
        List<Voie> vlistesecteur = vJdbcTemplate.query(vSQL,monmapvoie ,idsecteur);
        
        return vlistesecteur;
    }


    public void miseajour(Voie voie) {

    }


    public Site ajoutopo(Site site) {
        return null;
    }

    @Override
    public Voie getnid(int idvoie) {
        String vSQL = "SELECT * FROM public.voie where id= ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());
        MapperVoie monmapvoie = new MapperVoie();

        Secteur vvlistesecteur = vJdbcTemplate.queryForObject(vSQL, monmapvoie,idvoie);

        return (Voie) vvlistesecteur;
    }



    public Voie supprimevoie(int Id) {
        LOGGER.info("suppression d'une voie");
        String vSQL = "DELETE FROM public.voie where id= ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());
        vJdbcTemplate.update(vSQL,Id);

        return null;
    }

    @Override
    public Voie ajoutevoie(Voie voie, Integer idsecteur) {
        LOGGER.debug("essais sur methode mise a jour");
        String ajoutsql = "INSERT INTO public.voie " +
                " (nom,\n " +
                " cotation,\n " +
                " longueur,\n " +
                " secteurid,\n " +
                " niveau) " +
                "VALUES" +
                "(:nom,:cotation,:longueur,:secteurid,:niveau)";

        SqlParameterSource ajoutparam = new MapSqlParameterSource()
                .addValue("nom", voie.getNomvoie())
                .addValue("cotation", voie.getCotation())
                .addValue("longueur",voie.getLongueur())
                .addValue("secteurid",voie.getiD())
                .addValue("niveau",voie.getNiveau());

        //Gestion de la clé primaire
        KeyHolder holder = new GeneratedKeyHolder();
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDatasource());
        vJdbcTemplate.update(ajoutsql, ajoutparam, holder, new String[]{"id"});
        voie.setiD(holder.getKey().intValue());


        return null;
    }

    @Override
    public void misajour(Voie voie) {
        String maj = "UPDATE public.voie SET " +
                "nom = :nomVoie, \n" +
                "cotation = :cotation, \n" +
                "longueur = :longueur, \n" +
                "secteurid = :secteurid, \n" +
                "niveau = :niveau" +
                " WHERE id = :id";

        SqlParameterSource vParams = new BeanPropertySqlParameterSource(voie);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDatasource());
        int vNbrLigneMaJ = vJdbcTemplate.update(maj, vParams);

    }
}
