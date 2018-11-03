package org.topo.projetp6.impl.dao.mapper;


import org.bean.topo.projetp6.Utilisateur;
import org.bean.topo.projetp6.Voie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperUtilisateur implements RowMapper<Utilisateur> {



        @Override
        public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {

            Utilisateur nutil=new Utilisateur(rs.getInt("id"));
            nutil.setIdentifiant(rs.getString("identifiant"));
            nutil.setNom(rs.getString("nom"));
            nutil.setPrenom(rs.getString("prenom"));
            nutil.setEmail(rs.getString("email"));
            nutil.setLangue(rs.getString("langue"));
            nutil.setMotDePasse(rs.getString("motdepasse"));




            return nutil;
        }
    }


