package org.bean.topo.projetp6;


import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.List;

public class Secteur extends Site {
	private int iD;



	@NotEmpty(message="Model = Renseigner le nom")
	@NotBlank(message ="Model =Renseigner le nom")
	@Size(min = 1,max = 20,message = "Model , ne dot pas depasser 20 charactere")
	private String nomSecteur;


	@NotEmpty(message="Model = Renseigner l'objet de votre Commentaire")
	@NotBlank(message ="Model =Renseigner l'objet de votre Commentaire")
	@Size(min = 1,max = 400,message = "Model , ne dot pas depasser 400 charactere")
	@NegativeOrZero(message = "model doit et positif")
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