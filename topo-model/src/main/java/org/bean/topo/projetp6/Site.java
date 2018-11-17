package org.bean.topo.projetp6;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.List;

public class Site extends Topo {
	private int iD;



	@NotEmpty(message="Model = Renseigner le nom")
	@NotBlank(message ="Model =Renseigner le nom")
	@Size(min = 1,max = 20,message = "Model , ne dot pas depasser 20 charactere")
	private String nom;


	@NotEmpty(message="Model = Renseigner les coordonnées GPS")
	@NotBlank(message ="Model =Renseigner les coordonnées GPS")
	private String coordonneesGps;


//	public Topo topo;

	private List<Secteur> secteurs;


	public Site(int iD) {
		super(iD);
	}

	public int getiD() {
		return iD;
	}

	@Override
	public void setiD(int iD) {
		this.iD = iD;
	}



	@Override
	public String getNom() {
		return nom;
	}

	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCoordonneesGps() {
		return coordonneesGps;
	}

	public void setCoordonneesGps(String coordonneesGps) {
		this.coordonneesGps = coordonneesGps;
	}
/**
	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}
*/
	public List<Secteur> getSecteurs() {
		return secteurs;
	}

	public void setSecteurs(List<Secteur> secteurs) {
		this.secteurs = secteurs;
	}

	public Site() {
	}


	@Override
	public String toString() {
		return "Site{" +
				"iD=" + iD +
				", nom='" + nom + '\'' +
				", coordonneesGps='" + coordonneesGps + '\'' +
//				", topo=" + topo +
				", secteurs=" + secteurs +
				'}';
	}
}
