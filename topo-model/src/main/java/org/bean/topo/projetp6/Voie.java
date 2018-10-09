package org.bean.topo.projetp6;


import java.util.List;

public class Voie extends Secteur {
	private int iD;
	private String nomvoie;
	private String cotation;
	private String longueur;
	private String niveau;
	private List secteur;
	private List voie;
	public Topo_reservable[] voie_reservable = new Topo_reservable[0];
	public Message_voie[] Message_voie = new Message_voie[0];


public Voie(){

}

public Voie(int iD){
	this.iD=iD;
}

	public int getiD() {
		return iD;
	}

	public void setMessage_voie(org.bean.topo.projetp6.Message_voie[] message_voie) {
		Message_voie = message_voie;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}


	public String getNomvoie() {
		return nomvoie;
	}

	public void setNomvoie(String nomvoie) {
		this.nomvoie = nomvoie;
	}

	public String getCotation() {
		return cotation;
	}

	public void setCotation(String cotation) {
		this.cotation = cotation;
	}

	public String getLongueur() {
		return longueur;
	}

	public void setLongueur(String longueur) {
		this.longueur = longueur;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public Topo_reservable[] getVoie_reservable() {
		return voie_reservable;
	}

	public void setVoie_reservable(Topo_reservable[] voie_reservable) {
		this.voie_reservable = voie_reservable;
	}

	public org.bean.topo.projetp6.Message_voie[] getMessage_voie() {
		return Message_voie;
	}
}