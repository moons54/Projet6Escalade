package org.topo.projetp6.managerimpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bean.topo.projetp6.Reservation;
import org.bean.topo.projetp6.TopoReservable;
import org.bean.topo.projetp6.Utilisateur;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.topo.projetp6.impl.dao.ReservationDao;
import org.topo.projetp6.impl.dao.TopoReservableDao;
import org.topo.projetp6.impl.dao.UtilisateurDao;
import org.topo.projetp6.manager.AbstractManager;
import org.topo.projetp6.manager.ReservationManager;
import org.topo.projetp6.manager.ToporeservableManager;

import javax.inject.Inject;
import javax.inject.Named;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

@Named
public class ReservationManagerimpl extends AbstractManager implements ReservationManager {
    private static final Logger LOGGER=(Logger) LogManager.getLogger(ReservationManagerimpl.class);

  private List<Reservation> listresa= new ArrayList<Reservation>();

    @Inject
    private TopoReservableDao topoReservableDao;

    @Inject
    private UtilisateurDao utilisateurDao;

    @Inject
    private ReservationDao reservationDao;

    @Inject
    private ToporeservableManager toporeservableManager;


    @Inject
    @Named("TXtransactionTOPO")
    private PlatformTransactionManager platformTransactionManager;


    @Override
    public List<Reservation> affichelistedesreservations() {
        LOGGER.info("Methode Affiche reservation manager");
        List<Utilisateur> utilisateurList=getDaoFactory().getUtilisateurDao().listutilisateur();
List<TopoReservable> topoReservableList=toporeservableManager.affichelestoposempruntable();
      //  getDaoFactory().getTopoReservableDao().affichedisponbile();
       List<Reservation> listresa=reservationDao.listedesreservation();

        for (Reservation r: listresa){
            for(Utilisateur u: utilisateurList){
                if(r.getUtilisateur().getiD()==(u.getiD())){
                    r.setUtilisateur(u);
                }

            }
            for (TopoReservable t:topoReservableList){
                if(r.getTopoReservable().getiD()==(t.getiD())){
                    r.setTopoReservable(t);
                }
            }
        }
     //   System.out.println("val de listresta dans bcl"+listresa);
        return listresa;
    }

    @Override
    public Reservation getReservatinbyId(int Id) {
        LOGGER.info("Methode Affiche reservation par ID manager");
        Reservation reservation=getDaoFactory().getReservationDao().getById(Id);
        List<Utilisateur> utilisateurList=getDaoFactory().getUtilisateurDao().listutilisateur();
        List<TopoReservable> topoReservableListe=toporeservableManager.affichelestoposempruntable();
        for(Utilisateur t: utilisateurList){

            if (t.getiD()==reservation.getUtilisateur().getiD()){

                reservation.setUtilisateur(t);
                System.out.println("ds la bcle"+reservation.toString());
            }

        }
        for(TopoReservable u: topoReservableListe)
            if (u.getiD()==reservation.getTopoReservable().getiD()){

                reservation.setTopoReservable(u);
                System.out.println("ds la bcle"+reservation.toString());
            }
        System.out.println("valeur de resa"+reservation);
        return reservation;
    }

    @Override
    public void nouvellereservation(Reservation reservation) {
        LOGGER.info("Methode Creation d'une reservation manager");
        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                reservationDao.ajoutereservation(reservation);
            }
        });

    }

    @Override
    public void misajour(Reservation reservation) {
        LOGGER.info("Methode Modification d'une reservation manager");
        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                reservationDao.misajour(reservation);
            }
        });

    }

    @Override
    public void annulereservation(int Id) {
        LOGGER.info("Methode suppression d'une reservation manager");
        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                reservationDao.annuleReservation(Id);
            }
        });

    }


    public List<Reservation> affichepardate(Date debut, Date fin, Integer toporeverableid) {
        LOGGER.info("Mehtode controle des date sur untopo manager");
        List<Reservation> reservation=  getDaoFactory().getReservationDao().affichepardate(debut,fin,toporeverableid);
        return reservation;
    }
}
