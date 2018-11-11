package org.bean.topo.projetp6;

import java.util.Arrays;
import java.util.Date;

public class Message {
	private int iD;
	private Integer identifiant;
	private String message;
	private Date dateEcriture;
	private Topo topo;
	private Integer note;
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


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}

	@Override
	public String toString() {
		return "Message{" +
				"iD=" + iD +
				", identifiant=" + identifiant +
				", message='" + message + '\'' +
				", dateEcriture=" + dateEcriture +
				", topo=" + topo +
				", utilisateur=" + utilisateur +
				'}';
	}
}