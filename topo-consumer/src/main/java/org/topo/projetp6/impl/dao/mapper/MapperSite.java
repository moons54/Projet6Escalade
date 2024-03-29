package org.topo.projetp6.impl.dao.mapper;

import org.bean.topo.projetp6.Secteur;
import org.bean.topo.projetp6.Site;
import org.bean.topo.projetp6.Topo;
import org.springframework.jdbc.core.RowMapper;
import org.topo.projetp6.impl.dao.SecteurDAO;
import org.topo.projetp6.impl.dao.SiteDao;
import org.topo.projetp6.impl.dao.TopoDaoImpl;
import org.topo.projetp6.impl.dao.SiteDaoimpl;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MapperSite implements RowMapper<Site> {


private SecteurDAO secteurDAO;


    public MapperSite(SecteurDAO secteurDAO){
        this.secteurDAO=secteurDAO;
    }

        @Override
        public Site mapRow(ResultSet rs, int rowNum) throws SQLException {

            Site nmap = new Site(rs.getInt("topoid"));

            nmap.setNom(rs.getString("nom"));
            nmap.setCoordonneesGps(rs.getString("coordonnees_gps"));
            nmap.setiD(rs.getInt("id"));
            nmap.setTopo(new Topo(rs.getInt("topoid")));

            nmap.setSecteurs(secteurDAO.affiche(rs.getInt("topoid")));



            return nmap;
        }
    }


