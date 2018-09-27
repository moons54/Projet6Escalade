package org.topo.projetp6.managerimpl;

import org.bean.topo.projetp6.Secteur;

import java.util.List;

public interface SecteurManager {




    public List<Secteur> affichelesecteur(int idtopo);

    public Secteur getbyID(int Id);
}
