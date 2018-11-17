package org.bean.topo.projetp6;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.List;

public class Voie extends Secteur {


	private int iD;

	@NotEmpty(message="Model = Renseigner le nom de la voie")
	@NotBlank(message ="Model =Renseigner le nom de la voie")
	@Size(min = 1,max = 30,message = "Model , ne dot pas depasser 30 charactere")
	private String nomvoie;


	private String cotation;

	private String longueur;

	private String difficulte;

	private List secteur;




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


	@Override
	public String getDifficulte() {
		return difficulte;
	}

	@Override
	public void setDifficulte(String difficulte) {
		this.difficulte = difficulte;
	}


	public List getSecteur() {
		return secteur;
	}

	public void setSecteur(List secteur) {
		this.secteur = secteur;
	}





}


