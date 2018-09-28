package org.topo.projetp6.impl.dao.mapper;

import org.bean.topo.projetp6.Secteur;
import org.bean.topo.projetp6.Site;
import org.springframework.jdbc.core.RowMapper;
import org.topo.projetp6.impl.dao.SiteDaoimpl;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperSecteur implements RowMapper<Secteur> {

    //Secteur secteur = new Secteur(id);
    @Inject
    SiteDaoimpl site;

        @Override
        public Secteur mapRow(ResultSet rs, int rowNum) throws SQLException {

            Secteur nmap = new Secteur(rs.getInt("siteid"));
            nmap.setNomsecteur(rs.getString("nomsecteur"));
            nmap.setNombreVoie(rs.getInt("nombrevoie"));
            nmap.setiD(rs.getInt("id"));
          //  nmap.setSite(rs.getObject(site.affiche(site.getbyiD(Id))));



            return nmap;
        }
    }


