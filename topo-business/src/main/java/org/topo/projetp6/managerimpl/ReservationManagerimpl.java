package org.topo.projetp6.managerimpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bean.topo.projetp6.Reservation;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.topo.projetp6.impl.dao.ReservationDao;
import org.topo.projetp6.impl.dao.TopoReservableDao;
import org.topo.projetp6.impl.dao.UtilisateurDao;
import org.topo.projetp6.manager.AbstractManager;
import org.topo.projetp6.manager.ReservationManager;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
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
    @Named("TXtransactionTOPO")
    private PlatformTransactionManager platformTransactionManager;


    @Override
    public List<Reservation> affichelistedesreservations() {
        LOGGER.info("Methode Affiche reservation manager");
        listresa=getDaoFactory().getReservationDao().listedesreservation();
        return this.listresa;
    }

    @Override
    public Reservation getReservatinbyId(int Id) {
        LOGGER.info("Methode Affiche reservation par ID manager");
        Reservation reservation=getReservatinbyId(Id);
        return null;
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
}
