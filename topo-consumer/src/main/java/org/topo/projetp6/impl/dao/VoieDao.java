package org.topo.projetp6.impl.dao;

import org.bean.topo.projetp6.Voie;

import java.util.List;

public interface VoieDao {


    public List<Voie> affiche(int idsite);



    public Voie getnid(int idvoie);

    public Voie supprimevoie(int idvoie);


    public Voie ajoutevoie(Voie voie,Integer idsecteur);


    public void misajour(final Voie voie);

}
