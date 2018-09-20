package org.topo.projetp6.impl.dao;

import org.bean.topo.projetp6.Topo;

import java.util.List;

public interface TopoDao  {

//afficher la liste des topos
    public List<Topo> affiche();

//faire une mise a jour du nom des topos
public void miseajour(Topo topo);


//ajouter un topo
    public Topo ajoutopo(Topo topo);


    //rechercher un topo par id

    public Topo getbyiD(int Id);


    //Supprimer un topo
    public Topo supprimetopo(int Id);



}
