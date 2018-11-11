package org.topo.projetp6.managerimpl;

import org.bean.topo.projetp6.Message;
import org.bean.topo.projetp6.Reservation;
import org.topo.projetp6.manager.AbstractManager;
import org.topo.projetp6.manager.MessageManager;

import javax.inject.Named;
import java.util.List;

@Named
public class MessageManagerimpl extends AbstractManager implements MessageManager {
    @Override
    public List<Message> affichelesmessage() {
        return null;
    }

    @Override
    public Message getMessageById(int Id) {
        return null;
    }

    @Override
    public void nouveaumessage(Message message) {

    }

    @Override
    public void misajour(Message message) {

    }

    @Override
    public void supprimemessage(int Id) {

    }

    @Override
    public List<Reservation> afficheparutilisateur(int userid) {
        return null;
    }

    @Override
    public List<Reservation> affichepartopo(int topoid) {
        return null;
    }
}
