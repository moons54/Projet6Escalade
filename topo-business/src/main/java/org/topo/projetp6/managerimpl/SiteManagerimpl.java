package org.topo.projetp6.managerimpl;

import org.bean.topo.projetp6.Secteur;
import org.bean.topo.projetp6.Site;
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
import java.util.List;

@Named
public class SiteManagerimpl extends AbstractManager implements SiteManager {

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


}
