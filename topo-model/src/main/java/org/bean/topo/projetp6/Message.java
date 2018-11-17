package org.bean.topo.projetp6;

import java.util.Arrays;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class Message {
	private int iD;

	@NotEmpty(message="Model = Renseigner l'objet de votre Commentaire")
    @NotBlank(message ="Model =Renseigner l'objet de votre Commentaire")
    @Size(min = 1,max = 30,message = "Model , ne dot pas depasser 30 charactere")
	private String reference;

    @NotEmpty(message="Model = Renseigner l'objet de votre Commentaire")
    @NotBlank(message ="Model =Renseigner l'objet de votre Commentaire")
    @Size(min = 1,max = 400,message = "Model , ne dot pas depasser 400 charactere")
	private String commentaire;

	public Utilisateur utilisateur;

	public Topo topo;

	private Integer note;

	private Date messageDate;

    public Message() {
    }

    public Message(int iD) {
		this.iD = iD;
	}

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }



    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    @Override
    public String toString() {
        return "Message{" +
                "iD=" + iD +
                ", reference='" + reference + '\'' +
                ", commentaire='" + commentaire + '\'' +
                ", utilisateur=" + utilisateur +
                ", topo=" + topo +
                ", note=" + note +
                ", messageDate=" + messageDate +
                '}';
    }
}