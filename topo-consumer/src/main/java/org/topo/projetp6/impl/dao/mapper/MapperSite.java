package org.topo.projetp6.impl.dao.mapper;

import org.bean.topo.projetp6.Site;
import org.bean.topo.projetp6.Topo;
import org.springframework.jdbc.core.RowMapper;
import org.topo.projetp6.impl.dao.TopoDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperSite implements RowMapper<Site> {

    Site site = new Site();

        @Override
        public Site mapRow(ResultSet rs, int rowNum) throws SQLException {

            Site nmap = new Site(rs.getInt("topoid"));
            nmap.setIdentifiant(rs.getInt("identifiant"));
            nmap.setNom(rs.getString("nom"));
            nmap.setCoordonneesGps(rs.getString("coordonnees_gps"));
        nmap.setiD(rs.getInt("id"));
      // nmap.setTopo(rs.getObject);



            return nmap;
        }
    }


