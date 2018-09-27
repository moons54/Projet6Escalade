package org.topo.projetp6.managerimpl;

import org.bean.topo.projetp6.Secteur;
import org.bean.topo.projetp6.Site;
import org.springframework.transaction.PlatformTransactionManager;
import org.topo.projetp6.impl.dao.SecteurDAO;
import org.topo.projetp6.impl.dao.SiteDao;
import org.topo.projetp6.manager.AbstractManager;
import org.topo.projetp6.manager.SiteManager;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SecteurManagerimpl extends AbstractManager implements SecteurManager {

    /**
     * insertion de l'objet dao des topos
     */

    @Inject
    private SecteurDAO secteurDAO;

    @Inject
    @Named("TXtransactionTOPO")
    private PlatformTransactionManager platformTransactionManager;

   @Override
    public List<Secteur> affichelesecteur(int idsite) {
        return secteurDAO.affiche(idsite);
    }

    @Override
    public Secteur getbyID(int Id) {
        return null;
    }



}
