package org.topo.projetp6.manager;

import java.util.List;
import org.bean.topo.projetp6.Topo;
import org.bean.topo.projetp6.exception.FunctionalException;


public interface TopoManager {

    List<Topo> affichelistedestopos();

    Topo getTopo(int Id);

    public void ajoutopo(final Topo topo) throws FunctionalException;

    public void miseajour(final Topo topo);

    public Topo supprimetopo(final int Id);

    public List<Topo> recherchemulticritere(String troche,int note);
}
