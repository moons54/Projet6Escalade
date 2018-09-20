package org.topo.projetp6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.topo.projetp6.impl.DaoFactory;
import org.topo.projetp6.impl.dao.TopoDao;

import javax.inject.Named;

@Named
public class DaoFactoryImpl implements DaoFactory {


    private TopoDao topoDao;

  //private JndiObjectFactoryBean dataSourceTopo;


    public TopoDao getTopoDao() {
        return topoDao;
    }

    public void setTopoDao(TopoDao topoDao) {
        this.topoDao = topoDao;
    }
}
