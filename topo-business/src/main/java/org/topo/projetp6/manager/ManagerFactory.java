package org.topo.projetp6.manager;

import org.topo.projetp6.managerimpl.*;


public interface ManagerFactory {


   TopoManager getTopoManager();

   SiteManager getSiteManager();

}
