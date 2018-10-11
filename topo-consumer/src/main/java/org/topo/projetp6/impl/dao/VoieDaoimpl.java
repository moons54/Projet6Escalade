package org.topo.projetp6.impl.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bean.topo.projetp6.Secteur;
import org.bean.topo.projetp6.Site;
import org.bean.topo.projetp6.Voie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.topo.projetp6.impl.dao.mapper.MapperSecteur;
import org.topo.projetp6.impl.dao.mapper.MapperVoie;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class VoieDaoimpl extends AbstractDaoImpl implements VoieDao  {
    private static final Logger LOGGER=(Logger) LogManager.getLogger(TopoDaoImpl.class);

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
}
