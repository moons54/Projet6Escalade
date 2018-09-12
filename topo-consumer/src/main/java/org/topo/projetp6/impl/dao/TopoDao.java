package org.topo.projetp6.impl.dao;

import org.bean.topo.projetp6.Topo;

import javax.inject.Inject;
import java.util.List;
import org.bean.topo.projetp6.Topo;

public interface TopoDao  {

//afficher la liste des topos
    public List<Topo> affiche();

//faire une mise a jour du nom des topos
public void miseajour(Topo topo);


//ajouter un topo
    public Topo ajoutopo(Topo topo);


    //rechercher un topo par id

    public Topo getbyiD(int Id);



}
