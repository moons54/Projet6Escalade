package org.bean.topo.projetp6;


import java.util.Arrays;
import java.util.List;

public class Voie extends Secteur {
	private int iD;
	private String nomvoie;
	private String cotation;
	private String longueur;
	private String niveau;
	private List secteur;
	private List <Voie> voie;



public Voie(){

}

public Voie(int iD){
	this.iD=iD;
}

	public int getiD() {
		return iD;
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




	public List getSecteur() {
		return secteur;
	}

	public void setSecteur(List secteur) {
		this.secteur = secteur;
	}

	public List<Voie> getVoie() {
		return voie;
	}

	public void setVoie(List<Voie> voie) {
		this.voie = voie;
	}

	@Override
	public String toString() {
		return "Voie{" +
				"iD=" + iD +
				", nomvoie='" + nomvoie + '\'' +
				", cotation='" + cotation + '\'' +
				", longueur='" + longueur + '\'' +
				", niveau='" + niveau + '\'' +
				", secteur=" + secteur +
				", voie=" + voie +
				'}';
	}
}


