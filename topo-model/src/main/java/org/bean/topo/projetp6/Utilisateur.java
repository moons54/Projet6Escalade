package org.bean.topo.projetp6;

import org.bean.topo.projetp6.Message;
import org.bean.topo.projetp6.Reservation;

import java.util.Arrays;

public class Utilisateur {
	private int iD;
	private String identifiant;
	private String nom;
	private String prenom;
	private String email;
	private String langue;
	private String motDePasse;

	public Message[] message = new Message[0];
	public Reservation[] reservation = new Reservation[0];

	/**
	 * constructeur sur l'ID utilisateur
	 *
	 * @param iD
	 */
	public Utilisateur(int iD) {
		this.iD = iD;
	}


	/**
	 * LES GETTERS ET LES SETTERS
	 *
	 */
	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Message[] getMessage() {
		return message;
	}

	public void setMessage(Message[] message) {
		this.message = message;
	}

	public Reservation[] getReservation() {
		return reservation;
	}

	public void setReservation(Reservation[] reservation) {
		this.reservation = reservation;
	}


    /**
     * redefinition de la methode tostring
     *
     */
    @Override
    public String toString() {
        return "Utilisateur{" +
                "iD=" + iD +
                ", identifiant=" + identifiant +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", langue='" + langue + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", message=" + Arrays.toString(message) +
                ", reservation=" + Arrays.toString(reservation) +
                '}';
    }
}