package org.bean.topo.projetp6;

import java.util.Date;
public class Reservation {
	private int iD;
	private Date dateReservationDebut;
	private Date dateReservationFin;
	public Utilisateur utilisateur;
	public Topo_reservable voie_reservable;

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

	public Topo_reservable getVoie_reservable() {
		return voie_reservable;
	}

	public void setVoie_reservable(Topo_reservable voie_reservable) {
		this.voie_reservable = voie_reservable;
	}

	@Override
	public String toString() {
		return "Reservation{" +
				"iD=" + iD +
				", dateReservationDebut=" + dateReservationDebut +
				", dateReservationFin=" + dateReservationFin +
				", utilisateur=" + utilisateur +
				", voie_reservable=" + voie_reservable +
				'}';
	}
}
