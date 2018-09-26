package org.topo.projetp6.managerimpl;

import org.bean.topo.projetp6.Site;
import org.springframework.transaction.PlatformTransactionManager;
import org.topo.projetp6.impl.dao.SiteDao;
import org.topo.projetp6.manager.AbstractManager;
import org.topo.projetp6.manager.SiteManager;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SiteManagerimpl extends AbstractManager implements SiteManager {

    /**
     * insertion de l'objet dao des topos
     */

    @Inject
    private SiteDao siteDao;

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

}
