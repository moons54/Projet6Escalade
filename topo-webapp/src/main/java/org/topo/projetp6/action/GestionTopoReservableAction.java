package org.topo.projetp6.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bean.topo.projetp6.Topo;
import org.bean.topo.projetp6.TopoReservable;
import org.bean.topo.projetp6.Utilisateur;
import org.topo.projetp6.manager.ManagerFactory;

import javax.inject.Inject;
import java.util.List;

public class GestionTopoReservableAction extends ActionSupport {
    private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionTopoReservableAction.class);

    @Inject
    private ManagerFactory managerFactory;

    //LES ENTREES
    private List<TopoReservable> affichelistetoporeservable;

    private Topo topo;

    private TopoReservable topoReservable;

    private Utilisateur utilisateur;

    private Integer idtoporeservable;





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
        //gestion des erreurs si id du topo null
        if(idtoporeservable==null){
            this.addActionError(getText("error.topo.missing.id."));
        }else topoReservable = managerFactory.getToporeservableManager().getTopoByid(idtoporeservable);
        {
            // this.addActionError("il n'y a pas de projet pour ce numéro "+idtopo );


        }
        return (this.hasErrors())? ActionSupport.ERROR : ActionSupport.SUCCESS;

    };


}
