package org.topo.projetp6.impl;

import org.topo.projetp6.impl.dao.SiteDao;
import org.topo.projetp6.impl.dao.TopoDao;

public interface DaoFactory {


    TopoDao getTopoDao();

    SiteDao getSiteDao();
}