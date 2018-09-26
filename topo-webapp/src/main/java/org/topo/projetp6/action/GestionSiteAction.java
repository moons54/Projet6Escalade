package org.topo.projetp6.action;

import com.opensymphony.xwork2.ActionSupport;
import org.bean.topo.projetp6.Topo;
import org.bean.topo.projetp6.Site;
import org.topo.projetp6.impl.dao.SiteDaoimpl;
import org.topo.projetp6.impl.dao.TopoDaoImpl;
import org.topo.projetp6.manager.ManagerFactory;

import javax.inject.Inject;
import java.util.List;

public class GestionSiteAction extends ActionSupport {




    @Inject
    private ManagerFactory managerFactory;


    public Integer getIdtopo() {
        return idtopo;
    }

    public void setIdtopo(Integer idtopo) {
        this.idtopo = idtopo;
    }

    /**
     * Lien entre les actions et la bd
     */

    //les entrées et les sorties

    // les entrées
    private Integer idtopo;
    private Integer idsite;


     //Les sorties
    private List<Site> affichelistesite;



    private Topo topo;

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    private Site site;

    private TopoDaoImpl tpdao;
    private SiteDaoimpl sitedao;


    //les Getters et les Setters

        //affiche la liste des topos

    public List<Site> getAffichelistesite() {
        return affichelistesite;
    }

    public void setAffichelistesite(List<Site> affichelistesite) {
        this.affichelistesite = affichelistesite;
    }





        //recherche par id




    public Integer getIdsite() {
        return idsite;
    }

    public void setIdsite(Integer idsite) {
        this.idsite = idsite;
    }
//Les Methodes

    /**
     * création des classes d'actions
     *
     *
     */
    public String doList(){

        affichelistesite= managerFactory.getSiteManager().affichelessite(getIdtopo());

return ActionSupport.SUCCESS;
    };

    //methode permettant de crée un nouveau TOPO
    public String doCreate(){
        String vresult = ActionSupport.INPUT;

     //condition validant l'ajout de formulaire

        if (this.topo !=null) {

            if (this.topo.getNom() == null) {
                this.addFieldError(" topo.nom", "ne peut pas etre vide");

            } else {
                System.out.println("ok");
            }


            if (!this.hasErrors()) {
                try {
                    managerFactory.getTopoManager().ajoutopo(this.topo);
                    System.out.println("je suis la");
                    vresult = ActionSupport.SUCCESS;
                    this.addActionMessage("Nouveau Topo consultable et pret a l'emploi");
                } catch (Exception e) {

                    vresult = ActionSupport.ERROR;
                }

            }
        }

     return vresult;
    };


    public String doDetail(){
        //gestion des erreurs si id du topo null
        if(idsite==null){
            this.addActionError(getText("error.topo.missing.id."));
        }else site = managerFactory.getSiteManager().getbyID(idsite);
        {
             // this.addActionError("il n'y a pas de projet pour ce numéro "+idtopo );


        }
return (this.hasErrors())? ActionSupport.ERROR : ActionSupport.SUCCESS;

    };



    public String doSupp(){
String vresult=ActionSupport.INPUT;
        if (idsite == null) {
            this.addActionError(getText("error.topo.missing.id"));
        }else  managerFactory.getTopoManager().supprimetopo(this.idsite);
        vresult= ActionSupport.SUCCESS;
        this.addActionMessage("topo a bien été supprimé avec succes");

        {
    }
return vresult;
};
}
