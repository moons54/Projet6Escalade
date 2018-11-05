package org.topo.projetp6.impl;

import org.topo.projetp6.impl.dao.*;

public interface DaoFactory {


    TopoDao getTopoDao();

    SiteDao getSiteDao();

    SecteurDAO getSecteurDao();

    VoieDao getvoieDao();

    UtilisateurDao getUtilisateurDao();


    TopoReservableDao getTopoReservableDao();

    ReservationDao getReservationDao();
}