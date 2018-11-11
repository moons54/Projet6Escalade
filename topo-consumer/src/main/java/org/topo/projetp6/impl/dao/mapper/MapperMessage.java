package org.topo.projetp6.impl.dao.mapper;

import org.bean.topo.projetp6.Message;
import org.bean.topo.projetp6.Topo;
import org.bean.topo.projetp6.Utilisateur;
import org.springframework.jdbc.core.RowMapper;
import org.topo.projetp6.impl.dao.UtilisateurDao;


import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperMessage implements RowMapper<Message> {

    UtilisateurDao utilisateurDao;

    @Override
    public Message mapRow(ResultSet rs,int rowNum) throws SQLException {

        Message monmessage = new Message(rs.getInt("id"));
        monmessage.setDateEcriture(rs.getDate("dateecriture"));
        monmessage.setMessage(rs.getString("message"));
        monmessage.setIdentifiant(rs.getInt("identifiant"));
        monmessage.setUtilisateur(new Utilisateur(rs.getInt("utilisateurid")));
        monmessage.setTopo(new Topo(rs.getInt("topoid")));
        monmessage.setNote(rs.getInt("note"));
   return monmessage;
    }
}
