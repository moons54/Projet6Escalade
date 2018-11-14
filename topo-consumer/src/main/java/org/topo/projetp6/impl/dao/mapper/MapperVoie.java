package org.topo.projetp6.impl.dao.mapper;


import org.bean.topo.projetp6.Voie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperVoie implements RowMapper<Voie> {

    Voie voie = new Voie();

        @Override
        public Voie mapRow(ResultSet rs, int rowNum) throws SQLException {

            Voie nmap = new Voie(rs.getInt("secteurid"));
            nmap.setNom(rs.getString("nom"));
            nmap.setCotation(rs.getString("cotation"));
            nmap.setiD(rs.getInt("id"));
            nmap.setLongueur(rs.getString("longueur"));

            return nmap;
        }
    }


