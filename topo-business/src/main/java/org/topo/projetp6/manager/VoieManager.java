package org.topo.projetp6.manager;

import org.bean.topo.projetp6.Voie;

import java.util.List;

public interface VoieManager {



    public Voie getbynid(int id);


    public List<Voie> affichelesvoies(int idsecteur);

}
