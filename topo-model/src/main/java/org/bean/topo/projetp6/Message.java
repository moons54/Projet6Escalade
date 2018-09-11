package org.bean.topo.projetp6;

import java.util.Date;

public class Message {
	private int iD;
	private Integer identifiant;
	private String message;
	private Date dateEcriture;
	public Message_voie[] Message_voie_ = new Message_voie[0];
	public Utilisateur utilisateur;

	public Message(int iD) {
		this.iD = iD;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public Integer getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(Integer identifiant) {
		this.identifiant = identifiant;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateEcriture() {
		return dateEcriture;
	}

	public void setDateEcriture(Date dateEcriture) {
		this.dateEcriture = dateEcriture;
	}

	public Message_voie[] getMessage_voie_() {
		return Message_voie_;
	}

	public void setMessage_voie_(Message_voie[] message_voie_) {
		Message_voie_ = message_voie_;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}