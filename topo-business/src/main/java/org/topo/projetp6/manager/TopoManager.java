package org.topo.projetp6.manager;

import java.util.List;
import org.bean.topo.projetp6.Topo;


public interface TopoManager {

    List<Topo> affichelistedestopos();

    Topo getTopo(int Id);

    public void ajoutopo(final Topo topo);


}
