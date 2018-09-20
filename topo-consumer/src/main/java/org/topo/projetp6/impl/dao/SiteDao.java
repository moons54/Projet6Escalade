package org.topo.projetp6.impl.dao;


import org.bean.topo.projetp6.Site;

import java.util.List;


public interface SiteDao {



    //afficher la liste des topos
    public List<Site> affiche();

    //faire une mise a jour du nom des topos
    public void miseajour(Site site);


    //ajouter un topo
    public Site ajoutopo(Site site);


    //rechercher un topo par id

    public Site getbyiD(int Id);


    //Supprimer un topo
    public Site supprimetopo(int Id);
}
