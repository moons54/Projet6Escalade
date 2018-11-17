package org.topo.projetp6.managerimpl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bean.topo.projetp6.Secteur;
import org.bean.topo.projetp6.Site;
import org.bean.topo.projetp6.exception.FunctionalException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.topo.projetp6.impl.dao.SecteurDAO;
import org.topo.projetp6.impl.dao.TopoDao;
import org.topo.projetp6.impl.dao.SiteDao;
import org.topo.projetp6.manager.AbstractManager;
import org.topo.projetp6.manager.TopoManager;
import org.bean.topo.projetp6.Topo;

import org.topo.projetp6.managerimpl.SiteManagerimpl;


import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Named
public class TopoManagerimpl extends AbstractManager implements TopoManager {
    private static final Logger LOGGER=(Logger) LogManager.getLogger(TopoManagerimpl.class);

    /**
     * insertion de l'objet dao des topos
     */

    private List<Topo> listtopo=new ArrayList<Topo>();

    @Inject
    private TopoDao topoDao;

    @Inject
    private SiteDao siteDao;

    @Inject
    private SecteurDAO secteurDAO;

   @Inject
   private SiteManagerimpl siteManagerimpl;

    @Inject
    @Named("TXtransactionTOPO")
    private PlatformTransactionManager platformTransactionManager;

    /**
     * Methode retournant un topo
     * @param Id
     * @return le topo selectionné
     *
     */
    @Override
    public Topo getTopo(int Id) {

        Topo tops=  topoDao.getbyiD(Id);


    return tops;
    }


    /**
     * methode renvoyant la liste des topos
     * nous appelons le l'objet topo dao pour l'appeler
     * @return
     */
    @Override
    public List<Topo> affichelistedestopos(){

listtopo=getDaoFactory().getTopoDao().affiche();

     return this.listtopo;

    }

    /**
     * ajout d'un nouveau topo
     * @param ntopo
     */

    @Override
    public void ajoutopo(final Topo ntopo) throws FunctionalException {
        Set<ConstraintViolation<Topo>> vViolations = getConstraintValidator().validate(ntopo);
        if(!vViolations.isEmpty()) {
            for (ConstraintViolation<Topo> violation : vViolations) {
                LOGGER.info((violation.getMessage()));
            }
            throw new FunctionalException("Element a completer.");
        }
        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                topoDao.ajoutopo(ntopo);
            }
        });


    }

    public void miseajour(final Topo ntopo){
        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                topoDao.miseajour(ntopo);
            }
        });


    }

    public Topo supprimetopo(final int Id) {
        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                topoDao.supprimetopo(Id);
            }
        });

        return null;
    }

    public List<Topo> recherchemulticritere(String troche,int note){
        listtopo=getDaoFactory().getTopoDao().recherchemulticritere(troche,note);
    return listtopo;
    }
}
