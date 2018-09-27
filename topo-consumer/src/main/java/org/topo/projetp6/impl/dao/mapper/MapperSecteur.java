package org.topo.projetp6.impl.dao.mapper;

import org.bean.topo.projetp6.Secteur;
import org.bean.topo.projetp6.Site;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperSecteur implements RowMapper<Secteur> {

    //Secteur secteur = new Secteur(id);

        @Override
        public Secteur mapRow(ResultSet rs, int rowNum) throws SQLException {

            Secteur nmap = new Secteur(rs.getInt("topoid"));
            nmap.setIdentifiant(rs.getInt("identifiant"));
            nmap.setNom(rs.getString("nom"));
            nmap.setCoordonneesGps(rs.getString("coordonnees_gps"));
        nmap.setiD(rs.getInt("id"));



            return nmap;
        }
    }


