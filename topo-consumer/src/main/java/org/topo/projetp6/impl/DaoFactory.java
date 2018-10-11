package org.topo.projetp6.impl;

import org.topo.projetp6.impl.dao.SecteurDAO;
import org.topo.projetp6.impl.dao.SiteDao;
import org.topo.projetp6.impl.dao.TopoDao;
import org.topo.projetp6.impl.dao.VoieDao;

public interface DaoFactory {


    TopoDao getTopoDao();

    SiteDao getSiteDao();

    SecteurDAO getSecteurDao();

    VoieDao getvoieDao();




}