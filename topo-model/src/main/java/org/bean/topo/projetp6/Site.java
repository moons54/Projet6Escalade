package org.bean.topo.projetp6;


import java.util.Arrays;
import java.util.List;

public class Site extends Topo {
	private int iD;
	private Integer identifiant;
	private String nom;
	private String coordonneesGps;
	public Topo topo;
	private List <Secteur> secteurs;
	private List <Site> sites;

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

	public Integer getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(Integer identifiant) {
		this.identifiant = identifiant;
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

	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}

	public List<Secteur> getSecteurs() {
		return secteurs;
	}

	public void setSecteurs(List<Secteur> secteurs) {
		this.secteurs = secteurs;
	}

	public Site()  {
	}

	@Override
	public String toString() {
		return "Site{" +
				"iD=" + iD +
				", identifiant=" + identifiant +
				", nom='" + nom + '\'' +
				", coordonneesGps='" + coordonneesGps + '\'' +
				", topo=" + topo +
				", secteurs=" + secteurs +
				", sites=" + sites +
				", site=" + site +
				'}';
	}

	public List<Site> getSites() {
		return sites;
	}
}
