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


}