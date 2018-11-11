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
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class GestionTopoReservableAction extends ActionSupport {
    private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionTopoReservableAction.class);

    @Inject
    private ManagerFactory managerFactory;

    //LES ENTREES
    private List<TopoReservable> affichelistetoporeservable;
    private List<Reservation> affichereservation;
    private Topo topo;

    private TopoReservable topoReservable;

    private Utilisateur utilisateur;

    private Integer idtoporeservable;

    private Reservation reservation;

    private Date dat1;

    private Date date2;






    //GETTER ET SETTER


    public List<TopoReservable> getAffichelistetoporeservable() {
        return affichelistetoporeservable;
    }

    public void setAffichelistetoporeservable(List<TopoReservable> affichelistetoporeservable) {
        this.affichelistetoporeservable = affichelistetoporeservable;
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

    public Integer getIdtoporeservable() {
        return idtoporeservable;
    }

    public void setIdtoporeservable(Integer idtoporeservable) {
        this.idtoporeservable = idtoporeservable;
    }

    public TopoReservable getTopoReservable() {
        return topoReservable;
    }

    public void setTopoReservable(TopoReservable topoReservable) {
        this.topoReservable = topoReservable;
    }

    public List<Reservation> getAffichereservation() {
        return affichereservation;
    }

    public void setAffichereservation(List<Reservation> affichereservation) {
        this.affichereservation = affichereservation;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Date getDat1() {
        return dat1;
    }

    public void setDat1(Date dat1) {
        this.dat1 = dat1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    /**
     * CREATION DES CLASSES D'ACTIONS
     *
     *
     */

    public String doList(){

        affichelistetoporeservable= managerFactory.getToporeservableManager().affichelestoposempruntable();


        return ActionSupport.SUCCESS;
    };



    public String doDetail(){
      // LocalDate date = LocalDate.of(2018,11,10);
       // LocalDate date2 = LocalDate.of(2018,11,12);
//Date date= LocalDate.of(2018,11,)

        //gestion des erreurs si id du topo null
        if(idtoporeservable==null){
            this.addActionError(getText("error.topo.missing.id."));
        }else topoReservable = managerFactory.getToporeservableManager().getTopoByid(idtoporeservable);
        affichereservation=managerFactory.getReservationManager().affichelistedesreservations();
       // System.out.println("verification des val dates " + date+"   " +date2);
//List<Reservation> r =    managerFactory.getReservationManager().affichepardate(date, date2, 1);
  //      System.out.println("voir si ça apparait" +r.toString());
       {
            // this.addActionError("il n'y a pas de projet pour ce numéro "+idtopo );


        }
        return (this.hasErrors())? ActionSupport.ERROR : ActionSupport.SUCCESS;

    };


}
