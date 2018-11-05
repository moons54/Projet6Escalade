package org.topo.projetp6.managerimpl;
import org.bean.topo.projetp6.Topo;
import org.topo.projetp6.manager.ManagerFactory;
import org.topo.projetp6.manager.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("managerFactory")
public class ManagerFactoryimpl implements ManagerFactory {


    @Inject
    private TopoManager topomanager;

    @Inject
    private SiteManager siteManager;

    @Inject
    private SecteurManager secteurManager;

    @Inject
    private VoieManager VoieManager;

    @Inject
    private UtilisateurManager utilisateurManager;

    @Inject
    private ToporeservableManager toporeservableManager;

    @Inject
    private ReservationManager reservationManager;

    public void setVoieManager(org.topo.projetp6.manager.VoieManager voieManager) {
        VoieManager = voieManager;
    }

    @Override
    public TopoManager getTopoManager() {
        return this.topomanager;
    }

    public void setTopoManager(TopoManager TopoManager) {
        topomanager = TopoManager;
    }

    @Override
    public SiteManager getSiteManager() {
        return this.siteManager;
    }

    @Override
    public SecteurManager getSecteurManager() {
        return this.secteurManager;
    }

    public void setSiteManager(SiteManager siteManager) {
        this.siteManager = siteManager;
    }

    public void setSecteurManager(SecteurManager secteurManager) {
        this.secteurManager = secteurManager;
    }

    @Override
    public UtilisateurManager getUtilisateurManager() {
        return utilisateurManager;
    }



    public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
        this.utilisateurManager = utilisateurManager;
    }

    @Override
    public ToporeservableManager getToporeservableManager() {
        return toporeservableManager;
    }

    public void setToporeservableManager(ToporeservableManager toporeservableManager) {
        this.toporeservableManager = toporeservableManager;
    }

    @Override
    public ReservationManager getReservationManager() {
        return reservationManager;
    }

    public void setReservationManager(ReservationManager reservationManager) {
        this.reservationManager = reservationManager;
    }

    @Override
    public org.topo.projetp6.manager.VoieManager getVoieManager() {
        return VoieManager;
    }
}



