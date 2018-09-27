package org.topo.projetp6.impl.dao;

import org.bean.topo.projetp6.Secteur;
import org.bean.topo.projetp6.Site;

import java.util.List;

public interface SecteurDAO {




    public List<Secteur> affiche(int idsite);

    public Site getbyiD(int Id);
}
