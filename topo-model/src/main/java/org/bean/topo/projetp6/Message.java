package org.bean.topo.projetp6;

import java.util.Arrays;
import java.util.Date;

public class Message {
	private int iD;
	private String reference;
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