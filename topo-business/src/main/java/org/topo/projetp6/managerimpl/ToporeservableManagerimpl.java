package org.topo.projetp6.managerimpl;

import org.bean.topo.projetp6.TopoReservable;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.topo.projetp6.impl.dao.TopoDao;
import org.topo.projetp6.impl.dao.TopoReservableDao;
import org.topo.projetp6.impl.dao.UtilisateurDao;
import org.topo.projetp6.manager.AbstractManager;
import org.topo.projetp6.manager.ToporeservableManager;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class ToporeservableManagerimpl extends AbstractManager implements ToporeservableManager {

    private List<TopoReservable> listdispo=new ArrayList<TopoReservable>();


    @Inject
    private TopoReservableDao topoReservableDao;

    @Inject
    private UtilisateurDao utilisateurDao;

    @Inject
    private TopoDao topoDao;

    @Inject
    @Named("TXtransactionTOPO")
    private PlatformTransactionManager platformTransactionManager;


    @Override
    public List<TopoReservable> affichelestoposempruntable(int Id) {
        listdispo=getDaoFactory().getTopoReservableDao().affichedisponbile();
        return listdispo;
    }

    @Override
    public TopoReservable getTopoByid(int Id) {
        TopoReservable dispo = topoReservableDao.getByiD(Id);
        return dispo;
    }

    @Override
    public void ajoutopodisponible(TopoReservable topoReservable) {
        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
               topoReservableDao.ajoutdesreservables(topoReservable);
            }
        });
    }

    @Override
    public void retiretopodisponible(int Id) {
        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                topoReservableDao.retiredesreservables(Id);
            }
        });
    }

    @Override
    public void misajour(TopoReservable topoReservable) {

    }
}
