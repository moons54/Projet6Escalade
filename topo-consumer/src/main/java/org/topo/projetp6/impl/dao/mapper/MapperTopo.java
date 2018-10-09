package org.topo.projetp6.impl.dao.mapper;

import org.bean.topo.projetp6.Site;
import org.bean.topo.projetp6.Topo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.topo.projetp6.impl.dao.SiteDao;
import org.topo.projetp6.impl.dao.SiteDaoimpl;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MapperTopo implements RowMapper<Topo> {

@Autowired
SiteDaoimpl siteDaoimpl;

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
            montopo.setPhotoDuTopo(rs.getInt("photo_topo"));
            System.out.println("valeur de topo"+montopo);

         //   montopo.setSite(new Site[]{rs.getArray("id")});
/**
            Site[] tabl={};

            site = new Site();

*/



         //   System.out.println("voila l'objet sitedao" + sitedao.getbyiD(1));
            Site site;


     //     System.out.println(sitedao.recherche(rs.getInt("id")));
      //   System.out.println(sitedao.getbyiD(montopo.getiD()));
            site=siteDaoimpl.getbyiD(rs.getInt("id"));
            montopo.setSite(site.getSite());
      //      System.out.println("valeur apres declaration "+montopo);
           // System.out.println("valeur du tableau"+ site);
            //montopo.setSite(tabl);
          //  montopo.setSite(sitedao.getbyiD(rs.getArray("id")));
           // montopo.setStt(sitedao.getbyiD(rs.getInt("id")));
       //     montopo.setStt(sitedao.affiche(rs.getInt()));
        //  montopo.setSite(sitedao.affiche(rs.getInt("id")));
         //  montopo.setSite((Site) rs.getObject("id"));
        //    montopo.setSitev2(rs.findColumn("idsite"));
    //  montopo.setSite(rs.getArray("siteid"));
//montopo.setSitt(sitedao.recherche(rs.getInt("id")));
        //    montopo.setStt(sitedao.recherche(rs.getInt("id")));
            return montopo;
        }
    }


