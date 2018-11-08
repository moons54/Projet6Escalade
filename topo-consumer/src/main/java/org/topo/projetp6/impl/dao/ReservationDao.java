package org.topo.projetp6.impl.dao;

import org.bean.topo.projetp6.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationDao {
    public List<Reservation> listedesreservation();

    public Reservation getById(int Id);

    public Reservation annuleReservation(int Id);

    public  Reservation ajoutereservation(Reservation reservation);

    public void misajour(final Reservation reservation);

    public Reservation find(Integer Id);

    public Reservation affichepardate(Date debut, Date fin, Integer toporeverableid);




}
