package org.topo.projetp6.manager;

import org.bean.topo.projetp6.Secteur;


import java.util.List;

public interface SecteurManager {




    public List<Secteur> affichelesecteur(int idsite);

    public Secteur getbyID(int Idsite);

    public Secteur getbynid(int idsecteur);

    public Secteur supprimesecteur(final int Id);

}
