package org.topo.projetp6.impl.dao.mapper;

import org.bean.topo.projetp6.Site;
import org.bean.topo.projetp6.Topo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.topo.projetp6.impl.dao.SiteDao;
import org.topo.projetp6.impl.dao.SiteDaoimpl;
import org.topo.projetp6.impl.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class MapperTopo implements RowMapper<Topo> {



private SiteDao siteDao;


public MapperTopo(SiteDao siteDao){
    this.siteDao=siteDao;
}


        @Override
        public Topo mapRow(ResultSet rs, int rowNum) throws SQLException {

            Topo montopo = new Topo(rs.getInt("id"));
            montopo.setNom(rs.getString("nom"));
            montopo.setDescriptiondestopo(rs.getString("description_topo"));
            montopo.setHistoriquedestopo(rs.getString("historique_topo"));
            montopo.setHauteurDuTopo(rs.getString("hauteur_global"));
            montopo.setTypeDeroche(rs.getString("type_roche"));
            montopo.setNombreDevoie(rs.getInt("nombre_voie"));
            montopo.setDescriptionDuRetour(rs.getString("description_du_retour"));
            montopo.setTypeDequipement(rs.getString("type_equipement"));
            montopo.setPhotoDuTopo(rs.getString("photo_topo"));
            montopo.setNiveau(rs.getInt("niveau"));



                montopo.setSite(siteDao.affiche(rs.getInt("id")));

            return montopo;
        }
    }


