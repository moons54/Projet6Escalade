package org.bean.topo.projetp6;



public class Secteur extends Site {
	private int iD;
	private String nomSecteur;
	private Integer nombreVoie;
	public Voie[] voies = new Voie[0];

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

	public Voie[] getVoies() {
		return voies;
	}

	public void setVoies(Voie[] voies) {
		this.voies = voies;
	}

	public Secteur() {
	}
}