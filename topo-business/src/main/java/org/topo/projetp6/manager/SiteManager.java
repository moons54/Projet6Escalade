package org.topo.projetp6.manager;

import org.bean.topo.projetp6.Site;
import org.bean.topo.projetp6.exception.FunctionalException;

import java.util.List;

public interface SiteManager {


    List<Site> affichelessite(int idtopo);


    Site getbyID(int Id);

    public Site supprimesite(final int Id);

    public void ajoutsite(final Site nsite,Integer topoid) throws FunctionalException;

    void miseajour(final Site site);

    public Site recherche (int Id);
}