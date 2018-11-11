package org.topo.projetp6.manager;

import org.bean.topo.projetp6.Utilisateur;
import org.topo.projetp6.managerimpl.*;


public interface ManagerFactory {


   TopoManager getTopoManager();

   SiteManager getSiteManager();

   SecteurManager getSecteurManager();

   VoieManager getVoieManager();

   UtilisateurManager getUtilisateurManager();

   ToporeservableManager getToporeservableManager();

   ReservationManager getReservationManager();

   MessageManager getMessageManager();
}
