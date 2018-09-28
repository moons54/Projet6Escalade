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


    @Override
    public TopoManager getTopoManager() {
        return this.topomanager;
    }

    public void setTopoManager(TopoManager TopoManager) {
        topomanager = TopoManager;
    }


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
}



