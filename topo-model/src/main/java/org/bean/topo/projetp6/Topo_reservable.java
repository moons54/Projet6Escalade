package org.bean.topo.projetp6;

import org.bean.topo.projetp6.Reservation;
import java.util.Date;

public class Topo_reservable {
	private int iD;
	private Date datedispodebut;
	private Date datedispofin;
	private Voie voie;
	private Proprietaire proprietaire;
	private Topo topo;
	private Reservation[] reservation = new Reservation[0];

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public Date getDatedispodebut() {
		return datedispodebut;
	}

	public void setDatedispodebut(Date datedispodebut) {
		this.datedispodebut = datedispodebut;
	}

	public Date getDatedispofin() {
		return datedispofin;
	}

	public void setDatedispofin(Date datedispofin) {
		this.datedispofin = datedispofin;
	}

	public Voie getVoie() {
		return voie;
	}

	public void setVoie(Voie voie) {
		this.voie = voie;
	}

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}

	public Reservation[] getReservation() {
		return reservation;
	}

	public void setReservation(Reservation[] reservation) {
		this.reservation = reservation;
	}

}