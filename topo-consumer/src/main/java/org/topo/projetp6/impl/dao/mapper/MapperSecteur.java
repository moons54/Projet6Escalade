package org.topo.projetp6.impl.dao.mapper;

import org.bean.topo.projetp6.Secteur;
import org.bean.topo.projetp6.Site;
import org.springframework.jdbc.core.RowMapper;
import org.topo.projetp6.impl.dao.SiteDaoimpl;
import org.topo.projetp6.impl.dao.VoieDao;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperSecteur implements RowMapper<Secteur> {



    private VoieDao voieDao;


    public MapperSecteur(VoieDao voieDao){
        this.voieDao=voieDao;
    }
        @Override
        public Secteur mapRow(ResultSet rs, int rowNum) throws SQLException {

            Secteur nmap = new Secteur(rs.getInt("siteid"));
            nmap.setNomSecteur(rs.getString("nomsecteur"));
            nmap.setNombreVoie(rs.getInt("nombrevoie"));
            nmap.setiD(rs.getInt("id"));
            nmap.setDifficulte(rs.getString("difficulte"));


            nmap.setVoies(voieDao.affiche(rs.getInt("id")));

            return nmap;
        }
    }


