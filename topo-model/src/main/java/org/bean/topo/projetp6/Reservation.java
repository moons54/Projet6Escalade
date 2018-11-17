package org.bean.topo.projetp6;

import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import java.util.Date;
public class Reservation {
	private int iD;

	@Future(message = "pas de date inferieur a la date du jour")
	private Date dateReservationDebut;

	@Future(message = "pas de date inferieur a la date du jour")
	private Date dateReservationFin;

	public Utilisateur utilisateur;

	public TopoReservable topoReservable;

	public Reservation() {
	}

	public Reservation(int iD) {
		this.iD = iD;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public Date getDateReservationDebut() {
		return dateReservationDebut;
	}

	public void setDateReservationDebut(Date dateReservationDebut) {
		this.dateReservationDebut = dateReservationDebut;
	}

	public Date getDateReservationFin() {
		return dateReservationFin;
	}

	public void setDateReservationFin(Date dateReservationFin) {
		this.dateReservationFin = dateReservationFin;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public TopoReservable getTopoReservable() {
		return topoReservable;
	}

	public void setTopoReservable(TopoReservable topoReservable) {
		this.topoReservable = topoReservable;
	}

	@Override
	public String toString() {
		return "Reservation{" +
				"iD=" + iD +
				", dateReservationDebut=" + dateReservationDebut +
				", dateReservationFin=" + dateReservationFin +
				", utilisateur=" + utilisateur +
				", topoReservable=" + topoReservable +
				'}';
	}
}
