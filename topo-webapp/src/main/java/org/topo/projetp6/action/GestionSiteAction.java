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
    private String name;
    private Integer identifiant;
    private String coordonnesgps;


     //Les sorties
    private List<Site> affichelistesite;
    private List<Topo> listtop;

    public List<Topo> getListtop() {
        return listtop;
    }

    public void setListtop(List<Topo> listtop) {
        this.listtop = listtop;
    }

    public Topo topo;

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
  /**      String result=ActionSupport.INPUT;
        System.out.println(this.idtopo);
       topo= managerFactory.getTopoManager().getTopo(this.idtopo);

        if(name != null && identifiant !=null && coordonnesgps !=null){
            site.setNom(name);
            site.setIdentifiant(identifiant);
            site.setCoordonneesGps(coordonnesgps);
            managerFactory.getSiteManager().ajoutsite(site,this.idtopo);
            result=ActionSupport.SUCCESS;
        }




        return result;
    }
*/


        String vresult = ActionSupport.INPUT;

        //condition validant l'ajout de formulaire

        if (this.site !=null) {

            if (this.site.getNom() == null) {
                this.addFieldError(" topo.nom", "ne peut pas etre vide");
//if (this.site.getiD() == 0){

   // System.out.println("val de top"+topo);
//}
           } else {

                List <Topo> topoList = managerFactory.getTopoManager().affichelistedestopos();
//          this.site.setiD(idsite);
                setListtop(topoList);
            this.site.setiD(idsite);
                System.out.println("val de top"+topo);
            }


            if (!this.hasErrors()) {
                try {


                    managerFactory.getSiteManager().ajoutsite(this.site,idsite);
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

      //  return vresult;
   //}

    public String doDetail(){
        //gestion des erreurs si id du site null
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
        }else  managerFactory.getSiteManager().supprimesite(idsite);
        vresult= ActionSupport.SUCCESS;
        this.addActionMessage("Les site a bien été supprimé avec succes");

        {
    }
return vresult;
};
}
