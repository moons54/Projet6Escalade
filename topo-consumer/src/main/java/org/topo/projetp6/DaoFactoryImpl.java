package org.topo.projetp6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.topo.projetp6.impl.DaoFactory;
import org.topo.projetp6.impl.dao.SecteurDAO;
import org.topo.projetp6.impl.dao.SiteDao;
import org.topo.projetp6.impl.dao.TopoDao;

import javax.inject.Named;

@Named
public class DaoFactoryImpl implements DaoFactory {


    private TopoDao topoDao;
    private SiteDao siteDao;
    private SecteurDAO secteurDAO;


    public TopoDao getTopoDao() {
        return topoDao;
    }

    @Override
    public SiteDao getSiteDao() {
        return siteDao;
    }

    @Override
    public SecteurDAO getSecteurDao() {
        return secteurDAO;
    }

    public void setSiteDao(SiteDao siteDao) {
        this.siteDao = siteDao;
    }

    public void setSecteurDAO(SecteurDAO secteurDAO) {
        this.secteurDAO = secteurDAO;
    }

    public void setTopoDao(TopoDao topoDao) {
        this.topoDao = topoDao;
    }


}
