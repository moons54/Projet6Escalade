package org.topo.projetp6.impl.dao;


import org.bean.topo.projetp6.Site;

import java.util.List;


public interface SiteDao {



    //afficher la liste des topos
    public List<Site> affiche(int idtopo);
//TODO faire la mise a jour du site des que l'ensemble de la dépendance est terminé
    //faire une mise a jour du nom des topos
    public void miseajour(Site site);


    //ajouter un topo
    public Site ajoutesite(Site site,Integer idtopo);


    //rechercher un topo par id

    public Site getbyiD(int Id);


    public Site supprimesite(int Id);

    public List <Site> recherche(int Id );

}
