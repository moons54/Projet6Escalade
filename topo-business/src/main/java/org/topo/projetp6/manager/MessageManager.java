package org.topo.projetp6.manager;

import org.bean.topo.projetp6.Message;
import org.bean.topo.projetp6.Reservation;
import org.bean.topo.projetp6.exception.FunctionalException;

import java.util.List;

public interface MessageManager {

   List<Message> affichelesmessage();

   Message getMessageById(int Id);

   public void nouveaumessage(final Message message) throws FunctionalException;

   public void misajour(final Message message);

   public void supprimemessage(final int Id);

   public List<Message> afficheparutilisateur(int userid);

   public List<Message> affichepartopo(int topoid);


}
