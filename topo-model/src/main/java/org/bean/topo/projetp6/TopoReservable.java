package org.bean.topo.projetp6;

import org.bean.topo.projetp6.Reservation;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TopoReservable {
	private int iD;
	private Date datedispodebut;
	private Date datedispofin;
	private Topo topo;
	private Utilisateur utilisateur;


	public TopoReservable() {
	}

	public TopoReservable(int iD) {
		this.iD = iD;
	}

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


	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	@Override
	public String toString() {
		return "TopoReservable{" +
				"iD=" + iD +
				", datedispodebut=" + datedispodebut +
				", datedispofin=" + datedispofin +
				", topo=" + topo +
				", utilisateur=" + utilisateur +
				'}';
	}
}