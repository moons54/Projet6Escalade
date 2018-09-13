package org.topo.projetp6.action;

import com.opensymphony.xwork2.ActionSupport;
import javassist.NotFoundException;
import org.bean.topo.projetp6.*;
import java.util.List;
import java.util.Map;

import org.bean.topo.projetp6.Topo;
import org.topo.projetp6.impl.dao.TopoDaoImpl;
import org.topo.projetp6.manager.ManagerFactory;

import javax.inject.Inject;

public class GestionTopoAction extends ActionSupport {




    @Inject
    private ManagerFactory managerFactory;


    /**
     * Lien entre les actions et la bd
     */

    //les entrées et les sorties

    // les entrées
    private Integer idtopo;


    public void setAffichelistetopo(List<Topo> affichelistetopo) {
        this.affichelistetopo = affichelistetopo;
    }

    //Les sorties
    private List<Topo> affichelistetopo;



    private Topo topo;

    private TopoDaoImpl tpdao;

    //les Getters et les Setters

        //affiche la liste des topos
    public List<Topo> getAffichelistetopo() {
        return affichelistetopo;
    }
        //affiche les détail d'un topo
    public Topo getTopo() {
        return topo;
    }

        //recherche par id

    public Integer getIdtopo() {
        return idtopo;
    }

    public void setIdtopo(Integer idtopo) {
        this.idtopo = idtopo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

//Les Methodes

    /**
     * création des classes d'actions
     *
     *
     */
    public String doList(){

        affichelistetopo= managerFactory.getTopoManager().affichelistedestopos();

return ActionSupport.SUCCESS;
    };

    //methode permettant de crée un nouveau TOPO
    public String doCreate(){
     String vresult = ActionSupport.INPUT;

    if (this.topo !=null){


     //}
  //  if (this.hasErrors()){
         try {
             managerFactory.getTopoManager().ajoutopo(this.topo);
             vresult = ActionSupport.SUCCESS;
             this.addActionMessage("Nouveau Topo consultable et pret a l'emploi");
         } catch (Exception e) {

             vresult=ActionSupport.ERROR;
         }
     }
     return vresult;
    };


    public String doDetail(){
        //gestion des erreurs si id du topo null
        if(idtopo==null){
            this.addActionError(getText("error.topo.missing.id."));
        }else topo = managerFactory.getTopoManager().getTopo(idtopo);
        {
             // this.addActionError("il n'y a pas de projet pour ce numéro "+idtopo );


        }
return (this.hasErrors())? ActionSupport.ERROR : ActionSupport.SUCCESS;

    };

}
