package org.topo.projetp6.manager;

import org.bean.topo.projetp6.TopoReservable;

import java.util.List;

public interface ToporeservableManager {


    List<TopoReservable> affichelestoposempruntable();

    TopoReservable getTopoByid(int Id);

    public void ajoutopodisponible(final TopoReservable topoReservable);

    public void retiretopodisponible(final int Id);

    public void misajour(final TopoReservable topoReservable);

}
