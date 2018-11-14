package org.topo.projetp6.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.bean.topo.projetp6.Message;
import org.bean.topo.projetp6.Topo;
import org.bean.topo.projetp6.Utilisateur;
import org.topo.projetp6.manager.ManagerFactory;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.NoSuchElementException;

import org.topo.projetp6.action.loginAction;

public class GestionCommentaire extends ActionSupport {

    private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionCommentaire.class);


    @Inject
    private ManagerFactory managerFactory;


    //LES ENTREES
    private Integer idcommentaire;

    static Topo topo;

    private Message message;

    static Utilisateur utilisateur;

    private Integer numuser;

    private Integer idtopo;


    //LES SORTIES

    private List<Message> affichemcommentaire;

    //GETTERS ET SETTERS


    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Integer getNumuser() {
        return numuser;
    }

    public void setNumuser(Integer numuser) {
        this.numuser = numuser;
    }

    public Integer getIdcommentaire() {
        return idcommentaire;
    }

    public void setIdcommentaire(Integer idcommentaire) {
        this.idcommentaire = idcommentaire;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public static Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public static void setUtilisateur(Utilisateur utilisateur) {
        GestionCommentaire.utilisateur = utilisateur;
    }

    public List<Message> getAffichemcommentaire() {
        return affichemcommentaire;
    }

    public void setAffichemcommentaire(List<Message> affichemcommentaire) {
        this.affichemcommentaire = affichemcommentaire;
    }

    public Integer getIdtopo() {
        return idtopo;
    }

    public void setIdtopo(Integer idtopo) {
        this.idtopo = idtopo;
    }
    //Methode ACTION STRUTS

    public String doList(){
        LOGGER.info("Methode dolist de commentaireAction");
        affichemcommentaire=managerFactory.getMessageManager().affichelesmessage();
        return ActionSupport.SUCCESS;
    }
    public String doCreate(){
        LOGGER.info("Methode docreate commentaireAction");

        numuser=Integer.parseInt(loginAction.session.get("id").toString());


        String vresult = ActionSupport.INPUT;


        //condition validant l'ajout de formulaire
        System.out.println("par la 1");
        if (message != null) {
                System.out.println("ici");
            if (this.message.getCommentaire()== null)
            {
                this.addFieldError(" topo.nom", "ne peut pas etre vide");
                System.out.println("par la");
                System.out.println("val de message "+message);
            } else {
                topo = managerFactory.getTopoManager().getTopo(this.idtopo);

                message.setTopo(this.topo);
                utilisateur = managerFactory.getUtilisateurManager().getUtilisateur(this.numuser);
                message.setUtilisateur(utilisateur);
                System.out.println("ok" +message);
                //    dateDebut=  parse(reservation.getDateReservationDebut().toString());
                //   dateFin=parse(reservation.getDateReservationFin().toString());
                //affichemcommentaire=managerFactory.getReservationManager().affichepardate(reservation.getDateReservationDebut(), reservation.getDateReservationFin(), topoReservable.getiD());
            }

            //if (affichemcommentaire.size()==0) {
              //  System.out.println("ok pas de conflit ");
            //} else {
              //  System.out.println("pas bon");
                //this.addFieldError("topo.nom", "vide impossible");
            //}



            if (!this.hasErrors()) {
                try {

                    System.out.println(" est ce allé jusque la?"+message.toString());
                    managerFactory.getMessageManager().nouveaumessage(this.message);

                    vresult = ActionSupport.SUCCESS;
                    this.addActionMessage("Reservation ok consultable et pret a l'emploi");
                } catch (Exception e) {

                    vresult = ActionSupport.ERROR;
                }

            }
        }

        return vresult;


    }
    public String doSupp(){
        LOGGER.info("Methode dosupp de commentaireAction");
        String vresult=ActionSupport.INPUT;
        if (idcommentaire == null) {
            this.addActionError(getText("error.topo.missing.id"));
        }else  managerFactory.getMessageManager().supprimemessage(this.idcommentaire);
        vresult= ActionSupport.SUCCESS;
        this.addActionMessage("topo a bien été supprimé avec succes");

        {
        }
        return vresult;
    };
    public String doModif() {
        LOGGER.info("Methode domif de commentaireAction");

        String resultat = ActionSupport.INPUT;

        if (this.message != null) {
            if (this.message.getCommentaire()       != null) {
                try {
                    // Le formulaire a été envoyé, afin d'éviter la manipulation des données via le navigateur, on instancie un Topo temporaire
                    // Ainsi l'id est non modifiable.
                    Message tmpmessage = managerFactory.getMessageManager().getMessageById(message.getiD());
                    tmpmessage.setReference(message.getReference());
                  //  tmpmessage.setDateEcriture(message.getDateEcriture());
                    tmpmessage.setCommentaire(message.getCommentaire());
                    tmpmessage.setTopo(message.getTopo());
                    tmpmessage.setUtilisateur(message.getUtilisateur());
                    tmpmessage.setNote(message.getNote());
                    tmpmessage.setiD(topo.getiD());


                    managerFactory.getMessageManager().misajour(message);
                } catch (NoSuchElementException e) {
                    ServletActionContext.getResponse().setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
                resultat = ActionSupport.SUCCESS;
            } else {
                this.addActionError("Id doit être défini");
                resultat = ActionSupport.ERROR;
            }
        } else {
            // Si topo est null c'est qu'on va entrer sur la jsp update.jsp, il faut embarquer les données sur topo afin de pré-rempir les champs de la page web
            message = managerFactory.getMessageManager().getMessageById(idcommentaire);
        }
        return resultat;
    }
    public String doDetail(){
        //gestion des erreurs si id du topo null
        if(idcommentaire==null){
            this.addActionError(getText("error.topo.missing.id."));
        }else message = managerFactory.getMessageManager().getMessageById(idcommentaire);
        {
            // this.addActionError("il n'y a pas de projet pour ce numéro "+idtopo );


        }
        return (this.hasErrors())? ActionSupport.ERROR : ActionSupport.SUCCESS;

    }

}
