package org.topo.projetp6.impl.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bean.topo.projetp6.Utilisateur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
        LOGGER.info("recherche de la liste des utilisateur "+utilisateur.toString());


        return utilisateur;
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

    @Override
    public Utilisateur ajoututilisateur(Utilisateur utilisateur) {
        String ajoutsql = "INSERT INTO public.utilisateur" +
                " (identifiant,\n" +
                " nom,\n" +
                " prenom,\n" +
                " email,\n" +
                " langue,\n" +
                " motdepasse,\n" +
                " roleid)" +
                "VALUES" +
                "(:identifiant,:nom,:prenom,:email,:langue,:motdepasse,:roleid)";


        SqlParameterSource ajoututil = new MapSqlParameterSource()
                .addValue("identifiant",utilisateur.getIdentifiant())
                .addValue("nom",utilisateur.getNom())
                .addValue("prenom",utilisateur.getPrenom())
                .addValue("email",utilisateur.getEmail())
                .addValue("langue",utilisateur.getLangue())
                .addValue("motdepasse",utilisateur.getMotDePasse())
               .addValue("roleid",2);

        //Gestion de la clé primaire
        KeyHolder holder = new GeneratedKeyHolder();
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDatasource());
        vJdbcTemplate.update(ajoutsql, ajoututil, holder, new String[]{"id"});
        utilisateur.setiD(holder.getKey().intValue());
        return utilisateur;
    }

    @Override
    public Utilisateur misajourutilisateur(Utilisateur utilisateur) {

        String requetemaj = "UPDATE public.utilisateur SET " +
                "identifiant = :identifiant, \n" +
                "nom = :nom, \n" +
                "prenom = :prenom, \n" +
                "email = :email, \n" +
                "langue  = :langue, \n" +
                "motdepasse = :motdepasse" +
                " WHERE id = :iD";
        SqlParameterSource vParams = new BeanPropertySqlParameterSource(utilisateur);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDatasource());
        int vNbrLigneMaJ = vJdbcTemplate.update(requetemaj, vParams);

        return utilisateur;
    }

    @Override
    public Utilisateur supprimeUtilisateur(int Id) {
        LOGGER.info("suppression d'un utilisateur");
        String vSQL = "DELETE FROM public.utilisateur where id= ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());

        vJdbcTemplate.update(vSQL,Id);
        return null;
    }


}
