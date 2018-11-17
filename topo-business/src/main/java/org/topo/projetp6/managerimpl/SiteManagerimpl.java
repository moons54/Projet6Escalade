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
import org.topo.projetp6.impl.dao.SiteDao;
import org.topo.projetp6.manager.AbstractManager;
import org.topo.projetp6.manager.SiteManager;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

@Named
public class SiteManagerimpl extends AbstractManager implements SiteManager {
    private static final Logger LOGGER=(Logger) LogManager.getLogger(SiteManagerimpl.class);

    /**
     * insertion de l'objet dao des Sites
     */

    @Inject
    private SiteDao siteDao;

    @Inject
    private SecteurDAO secteurDAO;

    @Inject
    @Named("TXtransactionTOPO")
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public List<Site> affichelessite(int idtopo) {

        return siteDao.affiche(idtopo);
    }

    @Override
    public Site getbyID(int Id) {
        Site site= siteDao.getbyiD(Id);
     return site;
    }
    @Override
    public Site recherche (int Id) {
        Site site= siteDao.getbyiD(Id);
        return site;
    }

    @Override
    public Site supprimesite(final int Id) {
        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                siteDao.supprimesite(Id);
            }

        });
        return null;
    }

    @Override
    public void ajoutsite(final Site nsite, final Integer topoid) throws FunctionalException {
        Set<ConstraintViolation<Site>> vViolations = getConstraintValidator().validate(nsite);
        if(!vViolations.isEmpty()) {
            for (ConstraintViolation<Site> violation : vViolations) {
                LOGGER.info((violation.getMessage()));
            }
            throw new FunctionalException("Element a completer.");
        }
        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                siteDao.ajoutesite(nsite,topoid);
            }
        });

    }
    @Override
    public void miseajour(final Site site) {
        LOGGER.info("Methode mise a jour manager");
        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                siteDao.miseajour(site);
            }
        });
    }
}
