package org.topo.projetp6.impl.dao;


import org.bean.topo.projetp6.Site;

import javax.inject.Named;
import java.util.List;

@Named
public class SiteDaoimpl extends AbstractDaoImpl implements SiteDao  {


    @Override
    public List<Site> affiche() {
        return null;
    }

    @Override
    public void miseajour(Site site) {
        System.out.println("try");
    }

    @Override
    public Site ajoutopo(Site site) {
        return null;
    }

    @Override
    public Site getbyiD(int Id) {
        return null;
    }

    @Override
    public Site supprimetopo(int Id) {
        return null;
    }
}
