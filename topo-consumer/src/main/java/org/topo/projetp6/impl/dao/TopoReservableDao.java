package org.topo.projetp6.impl.dao;


import org.bean.topo.projetp6.TopoReservable;

import javax.inject.Named;
import java.util.List;



public interface TopoReservableDao {


    //Affiche la liste des topos empruntable
    public List<TopoReservable> affichedisponbile();

    //Affiche le détail d'un topo empruntable
    public TopoReservable getByiD(int Id);


    //Retirer de la liste des topos disponibles
    public TopoReservable retiredesreservables(int Id);

    //Ajouter de la liste des topos empruntables
    public TopoReservable ajoutdesreservables(TopoReservable topoReservable);

    //recherche par id
     public TopoReservable find(Integer id);

}
