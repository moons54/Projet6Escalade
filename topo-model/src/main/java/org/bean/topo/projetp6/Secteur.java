package org.bean.topo.projetp6;


import java.util.Arrays;
import java.util.List;

public class Secteur extends Site {
	private int iD;
	private String nomSecteur;
	private Integer nombreVoie;
	private List<Voie> voies;
	private String difficulte;
	private int experience;

	public Secteur(int iD) {
		super(iD);
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getNomSecteur() {
		return nomSecteur;
	}

	public void setNomSecteur(String nomSecteur) {
		this.nomSecteur = nomSecteur;
	}

	public Integer getNombreVoie() {
		return nombreVoie;
	}

	public void setNombreVoie(Integer nombreVoie) {
		this.nombreVoie = nombreVoie;
	}

	public String getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(String difficulte) {
		this.difficulte = difficulte;
	}

	public List<Voie> getVoies() {
		return voies;
	}

	public void setVoies(List<Voie> voies) {
		this.voies = voies;
	}

	public Secteur() {
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}


	@Override
	public String toString() {
		return "Secteur{" +
				"iD=" + iD +
				", nomSecteur='" + nomSecteur + '\'' +
				", nombreVoie=" + nombreVoie +
				", voies=" + voies +
				", difficulte='" + difficulte + '\'' +
				", experience=" + experience +
				'}';
	}
}