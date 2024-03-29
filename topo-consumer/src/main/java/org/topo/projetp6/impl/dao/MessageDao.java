package org.topo.projetp6.impl.dao;

import org.bean.topo.projetp6.Message;

import java.util.List;

public interface MessageDao {


    public List<Message> affichemessage();

    public Message getbyId(int Id);

    public Message supprimemessage(int Id);

    public Message ajoutemessage(final Message message);

    public void modifiemessage(final Message message);

    public List<Message> affichemessagebyTopo(int topoid);
}
