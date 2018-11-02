package org.topo.projetp6.impl.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bean.topo.projetp6.Utilisateur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.topo.projetp6.impl.dao.mapper.MapperTopo;
import org.topo.projetp6.impl.dao.mapper.MapperUtilisateur;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class UtilisateurDaoimpl extends AbstractDaoImpl implements UtilisateurDao{
    private static final Logger LOGGER=(Logger) LogManager.getLogger(UtilisateurDaoimpl.class);


    @Inject
    private UtilisateurDao utilisateurDao;


    @Override
    public Utilisateur getbyID(int Id) {
        //creation d'une requete avec pour resultat un parametre iD
        String vSQL = "SELECT * FROM public.utilisateur where id= ?";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());


       //RowMapper<Utilisateur> montops = new MapperUtilisateur(this.utilisateurDao);

        MapperUtilisateur maputil= new MapperUtilisateur();

        Utilisateur utilisateur = vJdbcTemplate.queryForObject(vSQL, maputil, Id);
        LOGGER.info("recherche de la liste de topo "+maputil.toString());


        return null;
    }

    @Override
    public Utilisateur getbyuserpass(String nom,String motdepasse) {
        System.out.println("methode getbyuser");
        //creation d'une requete avec pour resultat un parametre iD
      //  String vSQL = "SELECT * FROM public.utilisateur where nom= :nom and motdepasse= :motdepasse";
        String vSQL = "SELECT * FROM public.utilisateur where nom= :nom";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());



        MapperUtilisateur maputil= new MapperUtilisateur();

        Utilisateur utilisateur = vJdbcTemplate.queryForObject(vSQL, maputil,nom);
        System.out.println("val utilisateur"+utilisateur);
        LOGGER.info("recherche l'utilisateur avec login et mdp "+utilisateur.toString());


        return utilisateur;
    }

    @Override
    public List<Utilisateur> listutilisateur() {
        //creation d'une requete avec pour resultat un parametre iD
        String vSQL = "SELECT * FROM public.utilisateur ";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());


        //RowMapper<Utilisateur> montops = new MapperUtilisateur(this.utilisateurDao);

        MapperUtilisateur maputil= new MapperUtilisateur();

        List<Utilisateur> vutil = vJdbcTemplate.query(vSQL, maputil);
        LOGGER.info("recherche de la liste des utilisateur "+vutil.toString());


        return vutil;
    }
}
