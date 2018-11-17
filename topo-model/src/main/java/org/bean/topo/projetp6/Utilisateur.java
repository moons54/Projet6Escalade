package org.bean.topo.projetp6;

import org.bean.topo.projetp6.Message;
import org.bean.topo.projetp6.Reservation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Arrays;

public class Utilisateur {
	private int iD;

	@NotEmpty(message="Model = Renseigner votre identifiant de connexion")
	@NotBlank(message ="Model = Renseigner votre identifiant de connexion")
	@Size(min = 1,max = 10,message = "Model , ne dot pas depasser 10 charactere")
	private String identifiant;

	@NotEmpty(message="Model = Renseigner votre nom")
	@NotBlank(message ="Model =Renseigner votre nom")
	@Size(min = 1,max = 30,message = "Model , ne dot pas depasser 30 charactere")
	private String nom;

	@NotEmpty(message="Model = Renseigner renseigner votre prenom")
	@NotBlank(message ="Model =Renseigner renseigner votre prenom")
	@Size(min = 1,max = 400,message = "Model , ne dot pas depasser 400 charactere")
	private String prenom;


	private String email;

	private String langue;

	@NotEmpty(message="Model = Renseigner l'objet de votre Commentaire")
	@NotBlank(message ="Model =Renseigner l'objet de votre Commentaire")
	@Size(min = 1,max = 400,message = "Model , ne dot pas depasser 400 charactere")
	private String motDePasse;


	private String role;


	private int experience;


	/**
	 * constructeur sur l'ID utilisateur
	 *
	 * @param iD
	 */



	public Utilisateur(int iD) {
		this.iD = iD;
	}

	public Utilisateur() {

	}



	/**
	 * LES GETTERS ET LES SETTERS
	 *
	 */
	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * redefinition de la methode tostring
	 */
	@Override
	public String toString() {
		return "Utilisateur{" +
				"iD=" + iD +
				", identifiant='" + identifiant + '\'' +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", email='" + email + '\'' +
				", langue='" + langue + '\'' +
				", motDePasse='" + motDePasse + '\'' +
				", role='" + role + '\'' +
				", experience=" + experience +
				'}';
	}
}