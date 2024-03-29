package org.topo.projetp6.impl.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bean.topo.projetp6.Secteur;
import org.bean.topo.projetp6.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.topo.projetp6.impl.dao.mapper.MapperSecteur;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SecteurDaoimpl extends AbstractDaoImpl implements SecteurDAO  {
    private static final Logger LOGGER=(Logger) LogManager.getLogger(SecteurDaoimpl.class);

    @Inject
    private SecteurDAO secteurDAO;

    @Inject
    VoieDao voieDao;

    @Override
    public List<Secteur> affiche(int idsite) {
        LOGGER.info("Methode Affiche DAO");
        //requete SQL dans bd pour recupperer liste des sites
        String vSQL = "SELECT * FROM public.secteur where siteid= ?";
        //String vSQL = "SELECT * FROM public.secteur";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());

        MapperSecteur monmapsecteur = new MapperSecteur(this.voieDao);
        
        
        List<Secteur> vlistesecteur = vJdbcTemplate.query(vSQL, monmapsecteur,idsite);
        
        return vlistesecteur;
    }


    public void miseajour(Site site) {

    }


    public Secteur ajoutesecteur(Secteur secteur,Integer idsite) {
        LOGGER.info("Methode ajoutesecteur DAO");

        String ajoutsql = "INSERT INTO public.secteur " +
                " (nomsecteur,\n " +
                " nombrevoie,\n " +
                " siteid, \n " +
                " difficulte) " +
                "VALUES" +
                "(:nomsecteur,:nombrevoie,:siteid,:difficulte)";

        SqlParameterSource ajoutparam = new MapSqlParameterSource()
                .addValue("nomsecteur", secteur.getNomSecteur())
                .addValue("nombrevoie", secteur.getNombreVoie())
                .addValue("siteid",secteur.getiD())
                .addValue("difficulte",secteur.getDifficulte());
        //Gestion de la clé primaire
        KeyHolder holder = new GeneratedKeyHolder();
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDatasource());
        vJdbcTemplate.update(ajoutsql, ajoutparam, holder, new String[]{"id"});
        secteur.setiD(holder.getKey().intValue());


        return null;
    }

    @Override
    public void misajour(Secteur secteur) {
        LOGGER.info("Methode miseajour DAO");

        String maj = "UPDATE public.secteur SET " +
                "nomsecteur = :nomSecteur, \n" +
                "nombrevoie = :nombreVoie, \n" +
                "siteid = :siteid, \n" +
                "difficulte = :difficulte" +
                " WHERE id = :id";

        SqlParameterSource vParams = new BeanPropertySqlParameterSource(secteur);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDatasource());
        int vNbrLigneMaJ = vJdbcTemplate.update(maj, vParams);

    }

    @Override
    public Secteur getbyiD(int Id) {
        LOGGER.info("Methode getbyID DAO");

        //creation d'une requete avec pour resultat un parametre iD
        String vSQL = "SELECT * FROM public.secteur where id= ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());


        MapperSecteur monmapsecteur = new MapperSecteur(this.voieDao);


        Secteur secteur = vJdbcTemplate.queryForObject(vSQL, monmapsecteur,Id);



        return secteur;
    }

    @Override
    public Secteur getnid(int idsecteur) {
        String vSQL = "SELECT * FROM public.secteur where id= ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());
        MapperSecteur monmapsecteur = new MapperSecteur(this.voieDao);
        Secteur vvlistesecteur = vJdbcTemplate.queryForObject(vSQL, monmapsecteur,idsecteur);

        return vvlistesecteur;
    }



    public Secteur supprimesecteur(int Id) {
        LOGGER.info("Methode suppression d'un secteur DAO");
        String vSQL = "DELETE FROM public.secteur where id= ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());

        return null;
    }

}
