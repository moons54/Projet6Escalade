package org.topo.projetp6.impl.dao.mapper;

import org.bean.topo.projetp6.Message;
import org.bean.topo.projetp6.Topo;
import org.bean.topo.projetp6.Utilisateur;
import org.springframework.jdbc.core.RowMapper;
import org.topo.projetp6.impl.dao.UtilisateurDao;


import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class MapperMessage implements RowMapper<Message> {

    UtilisateurDao utilisateurDao;

    @Override
    public Message mapRow(ResultSet rs,int rowNum) throws SQLException {

        Message monmessage = new Message(rs.getInt("id"));
        monmessage.setReference(rs.getString("reference"));
        monmessage.setCommentaire(rs.getString("commentaire"));
        monmessage.setUtilisateur(new Utilisateur(rs.getInt("utilisateurid")));
        monmessage.setTopo(new Topo(rs.getInt("topoid")));
        monmessage.setNote(rs.getInt("note"));
        monmessage.setMessageDate(rs.getDate("date_message"));

   return monmessage;
    }
}
