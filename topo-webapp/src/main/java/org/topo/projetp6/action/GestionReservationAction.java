package org.topo.projetp6.action;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bean.topo.projetp6.Reservation;
import org.bean.topo.projetp6.Topo;
import org.bean.topo.projetp6.TopoReservable;
import org.bean.topo.projetp6.Utilisateur;
import org.topo.projetp6.manager.ManagerFactory;
import org.topo.projetp6.action.loginAction;

import javax.inject.Inject;

import java.time.LocalDate;
import java.time.Year;
import java.util.Date;
import java.util.List;

import static java.time.LocalDate.parse;

public class GestionReservationAction extends ActionSupport {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(GestionReservationAction.class);

    @Inject
    private ManagerFactory managerFactory;


    //LES ENTREES
    private List<Reservation> affichereservation;


    private Reservation reservation;

    private Reservation controle;

    private Topo topo;

    private Integer numuser;

    static  Utilisateur utilisateur;

    private Integer idreservation;

    static TopoReservable topoReservable;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    private Date bornedate;


    //GETTER ET SETTER


    public List<Reservation> getAffichereservation() {
        return affichereservation;
    }

    public void setAffichereservation(List<Reservation> affichereservation) {
        this.affichereservation = affichereservation;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Integer getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(Integer idreservation) {
        this.idreservation = idreservation;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public TopoReservable getTopoReservable() {
        return topoReservable;
    }

    public void setTopoReservable(TopoReservable topoReservable) {
        this.topoReservable = topoReservable;
    }


    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getNumuser() {
        return numuser;
    }

    public void setNumuser(Integer numuser) {
        this.numuser = numuser;
    }

    public Date getBornedate() {
        return bornedate;
    }

    public void setBornedate(Date bornedate) {
        this.bornedate = bornedate;
    }

    /**
     * CREATION DES CLASSES D'ACTIONS
     */

    public String doList() {
        LOGGER.info("Methode doLIst de gestionreservation");

        affichereservation = managerFactory.getReservationManager().affichelistedesreservations();

        return ActionSupport.SUCCESS;
    }


    ;

    public String doverification() {
        LOGGER.info("Methode doverification");

        String vresult = ActionSupport.INPUT;

        //condition validant l'ajout de formulaire

        if (this.dateDebut != null) {
            System.out.println("valeur de 1" + dateDebut + dateFin + idreservation);
            if (this.dateFin == null) {
                this.addFieldError(" topo.nom", "ne peut pas etre vide");

            } else {

                System.out.println("ok");
            }


            if (!this.hasErrors()) {
                System.out.println("valeur de 2" + dateDebut + dateFin + idreservation);
                try {
                    System.out.println("valeur de 3" + dateDebut + dateFin + idreservation);
              //      managerFactory.getReservationManager().affichepardate(dateDebut, dateFin, idreservation);

                    vresult = ActionSupport.SUCCESS;
                    this.addActionMessage("il y a deja des resa");
                } catch (Exception e) {

                    System.out.println("valeur de 4" + dateDebut + dateFin + idreservation);
                    vresult = ActionSupport.ERROR;
                }

            }
        }

        return vresult;
        //  reservation = managerFactory.getReservationManager().affichepardate(dateDebut, dateFin, idreservation);

        //return ActionSupport.SUCCESS;
    }


    public String doDetail() {
        LOGGER.info("Methode doDetail gestionreservation");
        //gestion des erreurs si id du topo null
        if (idreservation == null) {
            System.out.println("la");
            this.addActionError(getText("error.topo.missing.id."));
        } else reservation = managerFactory.getReservationManager().getReservatinbyId(idreservation);
        System.out.println("ici");
        {
            // this.addActionError("il n'y a pas de projet pour ce numéro "+idtopo );


        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;

    }

    ;

    public String doCreate() {
        LOGGER.info("dans le docreate de reservation");


        System.out.println("val de login"+loginAction.session.get("id"));
        numuser=Integer.parseInt(loginAction.session.get("id").toString());
        String vresult = ActionSupport.INPUT;

        //condition validant l'ajout de formulaire
        System.out.println("par la 1");
        if (this.reservation != null) {


            System.out.println("ici");
            if (this.reservation.getDateReservationDebut() == null) {
                this.addFieldError(" topo.nom", "ne peut pas etre vide");
                System.out.println("par la");
            } else {
                topoReservable = managerFactory.getToporeservableManager().getTopoByid(this.idreservation);

                reservation.setTopoReservable(topoReservable);
                utilisateur = managerFactory.getUtilisateurManager().getUtilisateur(numuser);
                reservation.setUtilisateur(utilisateur);
                System.out.println("ok");
           //    dateDebut=  parse(reservation.getDateReservationDebut().toString());
          //   dateFin=parse(reservation.getDateReservationFin().toString());
                affichereservation=managerFactory.getReservationManager().affichepardate(reservation.getDateReservationDebut(), reservation.getDateReservationFin(), topoReservable.getiD());
            }

            if (affichereservation.size()==0) {
                System.out.println("ok pas de conflit ");
            } else {
                System.out.println("pas bon");
                this.addFieldError("topo.nom", "vide impossible");
            }



            if (!this.hasErrors()) {
                try {
                    System.out.println(" est ce allé jusque la?");
                    managerFactory.getReservationManager().nouvellereservation(reservation);

                    vresult = ActionSupport.SUCCESS;
                    this.addActionMessage("Reservation ok consultable et pret a l'emploi");
                } catch (Exception e) {

                    vresult = ActionSupport.ERROR;
                }

            }
        }

        return vresult;


    }
}
