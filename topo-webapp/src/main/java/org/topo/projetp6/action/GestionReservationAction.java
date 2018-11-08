package org.topo.projetp6.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bean.topo.projetp6.Reservation;
import org.bean.topo.projetp6.Topo;
import org.bean.topo.projetp6.TopoReservable;
import org.bean.topo.projetp6.Utilisateur;
import org.topo.projetp6.manager.ManagerFactory;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

public class GestionReservationAction extends ActionSupport {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(GestionReservationAction.class);

    @Inject
    private ManagerFactory managerFactory;


    //LES ENTREES
    private List<Reservation> affichereservation;

    private Reservation reservation;

    private Topo topo;

    private Utilisateur utilisateur;

    private Integer idreservation;

    private TopoReservable topoReservable;

    private Date dateDebut;

    private Date dateFin;
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

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
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

            if (this.dateDebut !=null) {

                if (this.dateFin == null) {
                    this.addFieldError(" topo.nom", "ne peut pas etre vide");

                } else
                {

                    System.out.println("ok");
                }



                if (!this.hasErrors())
                {
                    try
                    {
                        managerFactory.getReservationManager().affichepardate(dateDebut, dateFin, idreservation);

                        vresult = ActionSupport.SUCCESS;
                        this.addActionMessage("il y a deja des resa");
                    } catch (Exception e)
                    {

                        vresult = ActionSupport.ERROR;
                    }

                }
            }

            return vresult;
      //  reservation = managerFactory.getReservationManager().affichepardate(dateDebut, dateFin, idreservation);

        //return ActionSupport.SUCCESS;
    }





    public String doDetail(){
        LOGGER.info("Methode doDetail gestionreservation");
        //gestion des erreurs si id du topo null
        if(idreservation==null){
            this.addActionError(getText("error.topo.missing.id."));
        }else reservation = managerFactory.getReservationManager().getReservatinbyId(idreservation);
        {
            // this.addActionError("il n'y a pas de projet pour ce numéro "+idtopo );


        }
        return (this.hasErrors())? ActionSupport.ERROR : ActionSupport.SUCCESS;

    };


}
