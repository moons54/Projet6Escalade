package org.topo.projetp6.impl.dao;


import org.bean.topo.projetp6.Secteur;
import org.bean.topo.projetp6.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.topo.projetp6.impl.dao.mapper.MapperSecteur;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SecteurDaoimpl extends AbstractDaoImpl implements SecteurDAO  {

    @Inject
    SecteurDAO secteurDAO;



    @Override
    public List<Secteur> affiche(int idsite) {
        //requete SQL dans bd pour recupperer liste des sites
        String vSQL = "SELECT * FROM public.secteur where siteid= ?";
        //String vSQL = "SELECT * FROM public.secteur";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());

        MapperSecteur monmapsecteur = new MapperSecteur();
        
        
        List<Secteur> vlistesecteur = vJdbcTemplate.query(vSQL, monmapsecteur,idsite);
        
        return vlistesecteur;
    }


    public void miseajour(Site site) {

    }


    public Site ajoutopo(Site site) {
        return null;
    }

    @Override
    public Secteur getbyiD(int Id) {
        //creation d'une requete avec pour resultat un parametre iD
        String vSQL = "SELECT * FROM public.secteur where id= ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());


        MapperSecteur monmapsecteur = new MapperSecteur();


        Secteur secteur = vJdbcTemplate.queryForObject(vSQL, monmapsecteur,Id);



        return secteur;
    }

    @Override
    public Secteur getnid(int idsecteur) {
        String vSQL = "SELECT * FROM public.secteur where id= ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());
        MapperSecteur monmapsecteur = new MapperSecteur();
        Secteur vvlistesecteur = vJdbcTemplate.queryForObject(vSQL, monmapsecteur,idsecteur);

        return vvlistesecteur;
    }


    //TODO faire l'implementation de supprimesecteur DAO
    public Site supprimetopo(int Id) {
        return null;
    }
}
