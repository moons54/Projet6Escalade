package org.topo.projetp6.impl.dao;

import org.bean.topo.projetp6.Message;

import javax.inject.Named;
import java.util.List;

@Named
public class MessageDaoimpl extends AbstractDaoImpl implements MessageDao{
    @Override
    public List<Message> affichemessage() {
        return null;
    }

    @Override
    public Message getbyId(int Id) {
        return null;
    }

    @Override
    public Message supprimemessage(Message message) {
        return null;
    }

    @Override
    public Message ajoutemessage(Message message) {
        return null;
    }

    @Override
    public void modifiemessage(Message message) {

    }
}
