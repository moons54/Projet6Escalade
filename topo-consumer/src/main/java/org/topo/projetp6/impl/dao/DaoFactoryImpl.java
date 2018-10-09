package org.topo.projetp6.impl.dao;

import org.bean.topo.projetp6.Secteur;
import org.topo.projetp6.impl.DaoFactory;

import javax.inject.Inject;
import javax.inject.Named;


@Named
public class DaoFactoryImpl implements DaoFactory {

  ///Injection des dao dans le cadre du pattern dao

    @Inject
    private SiteDao siteDao;


    @Inject
    private TopoDao topoDao;

    @Inject
    private SecteurDAO secteurDAO;


    @Inject
    private VoieDao voieDao;


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

    @Override
    public TopoDao getTopoDao() {
        return topoDao;
    }

    public void setTopoDao(TopoDao topoDao) {
        this.topoDao = topoDao;
    }



    public void setSecteurDAO(SecteurDAO secteurDAO) {
        this.secteurDAO = secteurDAO;
    }

    //TODO implementer voiedao
    /**
    @Override
    public VoieDao getVoieDao() {
        return voieDao;
    }

    public void setVoieDao(VoieDao voieDao) {
        this.voieDao = voieDao;
    }

    */

}
