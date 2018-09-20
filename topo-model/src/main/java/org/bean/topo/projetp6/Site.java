package org.bean.topo.projetp6;



public class Site extends Topo {
	private int iD;
	private Integer identifiant;
	private String nom;
	private String coordonnees_gps;
	public Topo topo;
	public Secteur[] secteurs = new Secteur[0];

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

	public String getCoordonnees_gps() {
		return coordonnees_gps;
	}

	public void setCoordonnees_gps(String coordonnees_gps) {
		this.coordonnees_gps = coordonnees_gps;
	}

	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}

	public Secteur[] getSecteurs() {
		return secteurs;
	}

	public void setSecteurs(Secteur[] secteurs) {
		this.secteurs = secteurs;
	}

	public Site() {
	}

}