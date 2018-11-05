package org.bean.topo.projetp6;


import java.util.Arrays;
import java.util.List;

public class Topo {
	private int iD;
	private String nom;
	private String descriptiondestopo;
	private String historiquedestopo;
	private String hauteurDuTopo;
	private String typeDeroche;
	private Integer nombreDevoie;
	private String descriptionDuRetour;
	private String typeDequipement;


    private int photoDuTopo;
    public List<Site> site;




	/**
	 * mis en place du constructeur Topo avec le parametre id *************************************
	 * @param iD
	 */

	public Topo(int iD) {
		this.iD = iD;
	}

    public Topo() {

    }

    /**
     ***************************** LES GETTERS ET LES SETTERS *************************************
     * @return
     */
    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescriptiondestopo() {
        return descriptiondestopo;
    }

    public void setDescriptiondestopo(String descriptiondestopo) {
        this.descriptiondestopo = descriptiondestopo;
    }

    public String getHistoriquedestopo() {
        return historiquedestopo;
    }

    public void setHistoriquedestopo(String historiquedestopo) {
        this.historiquedestopo = historiquedestopo;
    }

    public String getHauteurDuTopo() {
        return hauteurDuTopo;
    }

    public void setHauteurDuTopo(String hauteurDuTopo) {
        this.hauteurDuTopo = hauteurDuTopo;
    }

    public String getTypeDeroche() {
        return typeDeroche;
    }

    public void setTypeDeroche(String typeDeroche) {
        this.typeDeroche = typeDeroche;
    }

    public Integer getNombreDevoie() {
        return nombreDevoie;
    }

    public void setNombreDevoie(Integer nombreDevoie) {
        this.nombreDevoie = nombreDevoie;
    }

    public String getDescriptionDuRetour() {
        return descriptionDuRetour;
    }

    public void setDescriptionDuRetour(String descriptionDuRetour) {
        this.descriptionDuRetour = descriptionDuRetour;
    }

    public String getTypeDequipement() {
        return typeDequipement;
    }

    public void setTypeDequipement(String typeDequipement) {
        this.typeDequipement = typeDequipement;
    }

    public int getPhotoDuTopo() {
        return photoDuTopo;
    }

    public void setPhotoDuTopo(int photoDuTopo) {
        this.photoDuTopo = photoDuTopo;
    }


    public List<Site> getSite() {
        return site;
    }

    public void setSite(List<Site> site) {
        this.site = site;
    }



    /**
     * ********************************** La méthode to string *****************************************
     *
     * @return
     */
    @Override
    public String toString() {
        return "Topo{" +
                "iD=" + iD +
                ", nom='" + nom + '\'' +
                ", descriptiondestopo='" + descriptiondestopo + '\'' +
                ", historiquedestopo='" + historiquedestopo + '\'' +
                ", hauteurDuTopo='" + hauteurDuTopo + '\'' +
                ", typeDeroche='" + typeDeroche + '\'' +
                ", nombreDevoie=" + nombreDevoie +
                ", descriptionDuRetour='" + descriptionDuRetour + '\'' +
                ", typeDequipement='" + typeDequipement + '\'' +
                ", photoDuTopo=" + photoDuTopo +
                ", site=" + site +
                '}';
    }
}
