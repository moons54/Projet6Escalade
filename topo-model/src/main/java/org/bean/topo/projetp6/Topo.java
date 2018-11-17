package org.bean.topo.projetp6;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.List;

public class Topo {

	private int iD;
/**
    @NotEmpty(message="Model = Renseigner le nom")
    @NotBlank(message ="Model =Renseigner le nom")
    @Size(min = 1,max = 30,message = "Model , ne dot pas depasser 30 charactere")
	*/
    private String nom;

 /**   @NotEmpty(message="Model = Renseigner la description")
    @NotBlank(message ="Model =Renseigner la description")
    @Size(min = 1,max = 70,message = "Model , ne dot pas depasser 70 charactere")
	*/
    private String descriptiondestopo;
/**
    @NotEmpty(message="Model = Renseigner l'historique du topo")
    @NotBlank(message ="Model =Renseigner l'historique du topo")
    @Size(min = 1,max = 30,message = "Model , ne doit pas depasser 20 charactere")
*/
	private String historiquedestopo;

 //   @NotBlank(message="Model = Renseigner la hauteur du topo")
	private String hauteurDuTopo;

	private String typeDeroche;

//	@NotBlank(message="Model = Renseigner le nombre de voie")
	private Integer nombreDevoie;
/**
	@NotEmpty(message="Model = Renseigner le retour")
    @NotBlank(message="Model = Renseigner le retour")
    @Size(min = 1,max = 70,message = "Model , ne dot pas depasser 70 charactere")
   */
    private String descriptionDuRetour;
/**
    @NotEmpty(message="Model = Renseigner le type d'equipement")
    @NotBlank(message="Model = Renseigner le type d'equipement")
    @Size(min = 1,max = 70,message = "Model , ne dot pas depasser 70 charactere")
   */
    private String typeDequipement;


	private int niveau;


    private String photoDuTopo;

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

    public String getPhotoDuTopo() {
        return photoDuTopo;
    }

    public void setPhotoDuTopo(String photoDuTopo) {
        this.photoDuTopo = photoDuTopo;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
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
                ", niveau=" + niveau +
                ", photoDuTopo=" + photoDuTopo +
                ", site=" + site +
                '}';
    }
}
