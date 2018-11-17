package org.topo.projetp6.managerimpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bean.topo.projetp6.Message;
import org.bean.topo.projetp6.Reservation;
import org.bean.topo.projetp6.Topo;
import org.bean.topo.projetp6.Utilisateur;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.topo.projetp6.impl.dao.MessageDao;
import org.topo.projetp6.impl.dao.TopoDao;
import org.topo.projetp6.impl.dao.UtilisateurDao;
import org.topo.projetp6.manager.AbstractManager;
import org.topo.projetp6.manager.MessageManager;
import org.bean.topo.projetp6.exception.FunctionalException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

@Named
public class MessageManagerimpl extends AbstractManager implements MessageManager {
    private static final Logger LOGGER=(Logger) LogManager.getLogger(MessageManagerimpl.class);

@Inject
private UtilisateurDao utilisateurDao;

@Inject
private TopoDao topoDao;

@Inject
private MessageDao messageDao;


    @Inject
    @Named("TXtransactionTOPO")
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public List<Message> affichelesmessage()
    {
        LOGGER.info("Methode Lister des messages manager");
        List<Utilisateur> utilisateurList=getDaoFactory().getUtilisateurDao().listutilisateur();
        List<Topo> topoList=getDaoFactory().getTopoDao().affiche();
        List<Message> messageList=getDaoFactory().getMessageDao().affichemessage();

        for (Message m: messageList){
            for (Utilisateur u: utilisateurList){
                if(m.getUtilisateur().getiD()==u.getiD()){
                    m.setUtilisateur(u);
                }
            }
            for (Topo t: topoList){
                if (m.getTopo().getiD()==(t.getiD())){
                    m.setTopo(t);
                }
            }
        }
        return messageList;
    }

    @Override
    public Message getMessageById(int Id) {
        LOGGER.info("Methode Getbyid message par id manager");
        Message message=getDaoFactory().getMessageDao().getbyId(Id);
        List<Utilisateur> utilisateurList=getDaoFactory().getUtilisateurDao().listutilisateur();
        List<Topo> topoList=getDaoFactory().getTopoDao().affiche();
        for(Utilisateur t: utilisateurList){

            if (t.getiD()==message.getUtilisateur().getiD()){
                message.setUtilisateur(t);
            }
        }
        for (Topo u: topoList){
            if (u.getiD()==message.getTopo().getiD()){
                message.setTopo(u);
            }
        }


            return message;
    }

    @Override
    public void nouveaumessage(final Message nmessage) throws FunctionalException {
        LOGGER.info("Methode Nouveau Commentaire manager");

        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        Set<ConstraintViolation<Message>> vViolations = getConstraintValidator().validate(nmessage);
        if(!vViolations.isEmpty()) {
            for (ConstraintViolation<Message> violation : vViolations) {
                LOGGER.info((violation.getMessage()));
            }
            throw new FunctionalException("Element a completer.");
        }

        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {

               messageDao.ajoutemessage(nmessage);
            }
        });

    }

    @Override
    public void misajour(Message message) {
        LOGGER.info("Methode Mise à jour d'un commentaire manager");
        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                messageDao.modifiemessage(message);
            }
        });
    }

    @Override
    public void supprimemessage(int Id) {
        LOGGER.info("Methode suppression d'un commentaire");
        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                messageDao.supprimemessage(Id);
            }
        });
    }

    @Override
    public List<Message> afficheparutilisateur(int userid) {

        return null;
    }

    @Override
    public List<Message> affichepartopo(int topoid) {
        LOGGER.info("Methode Lister des messages manager");
        List<Utilisateur> utilisateurList=getDaoFactory().getUtilisateurDao().listutilisateur();
        List<Topo> topoList=getDaoFactory().getTopoDao().affiche();
        List<Message> messageList=getDaoFactory().getMessageDao().affichemessagebyTopo(topoid);
        for (Message m: messageList){
            for (Utilisateur u: utilisateurList){
                if(m.getUtilisateur().getiD()==u.getiD()){
                    m.setUtilisateur(u);
                }
            }
            for (Topo t: topoList){
                if (m.getTopo().getiD()==(t.getiD())){
                    m.setTopo(t);
                }
            }
        }
        return messageList;
    }
}
