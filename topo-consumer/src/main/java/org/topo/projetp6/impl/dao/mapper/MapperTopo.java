package org.topo.projetp6.impl.dao.mapper;

import org.bean.topo.projetp6.Topo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperTopo implements RowMapper<Topo> {



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

            return montopo;
        }
    }


