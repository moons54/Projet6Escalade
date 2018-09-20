package org.topo.projetp6.impl.dao.mapper;

import org.bean.topo.projetp6.Site;
import org.bean.topo.projetp6.Topo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperSite implements RowMapper<Site> {


 Topo tops = new Topo();
        @Override
        public Site mapRow(ResultSet rs, int rowNum) throws SQLException {

            Site nmap = new Site(rs.getInt("id"));
            nmap.setIdentifiant(rs.getInt("identifiant"));
            nmap.setNom(rs.getString("nom"));
            nmap.setCoordonnees_gps(rs.getString("coordonnees_gps"));
           nmap.setTopo((Topo) rs.getObject(5));

            return nmap;
        }
    }


