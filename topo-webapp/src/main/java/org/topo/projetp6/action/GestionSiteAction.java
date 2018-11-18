package org.topo.projetp6.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.bean.topo.projetp6.Topo;
import org.bean.topo.projetp6.Site;
import org.topo.projetp6.impl.dao.SiteDaoimpl;
import org.topo.projetp6.impl.dao.TopoDaoImpl;
import org.topo.projetp6.manager.ManagerFactory;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.NoSuchElementException;

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


    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public TopoDaoImpl getTpdao() {
        return tpdao;
    }

    public void setTpdao(TopoDaoImpl tpdao) {
        this.tpdao = tpdao;
    }

    public SiteDaoimpl getSitedao() {
        return sitedao;
    }

    public void setSitedao(SiteDaoimpl sitedao) {
        this.sitedao = sitedao;
    }

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
        System.out.println("val de idtopo"+idtopo);
        System.out.println("val de idsite"+idsite);
        affichelistesite= managerFactory.getSiteManager().affichelessite(idtopo);

return ActionSupport.SUCCESS;
    };

    //methode permettant de crée un nouveau Site
    public String doCreate(){


        String vresult = ActionSupport.INPUT;

        //condition validant l'ajout de formulaire

        if (this.site !=null)
            {
                 if (this.site.getNom() == null)
                    {
                        this.addFieldError(" topo.nom", "ne peut pas etre vide");
                    } else

                        {


                            this.site.setiD(idsite);
                        }if (!this.hasErrors())

                        {
                            try
                            {
                                managerFactory.getSiteManager().ajoutsite(this.site,idsite);
                                vresult = ActionSupport.SUCCESS;
                               // this.addActionMessage("Nouveau Topo consultable et pret a l'emploi");
                            } catch (Exception e)
                                {

                                     vresult = ActionSupport.ERROR;
                                }

                        }
            }

       return vresult;
    };



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


    public String doModif() {

        String resultat = ActionSupport.INPUT;

        if (this.site != null) {
            if (this.site.getNom() != null) {

                try {

                    // Le formulaire a été envoyé, afin d'éviter la manipulation des données via le navigateur, on instancie un Topo temporaire
                    // Ainsi l'id est non modifiable.
                   Site tpsite = managerFactory.getSiteManager().getbyID(idsite);
                    System.out.println("val de____ tpsite"+tpsite.toString());
                    tpsite.setNom(site.getNom());
                    tpsite.setCoordonneesGps(site.getCoordonneesGps());
                    System.out.println("valeur de topo"+idtopo);
                    tpsite.setTopo(site.getTopo());
                    tpsite.setiD(idsite);
                    tpsite.setSecteurs(site.getSecteurs());

                    setIdtopo(site.topo.getiD());

                    System.out.println("valeur de tpsitte ====="+tpsite);
                    System.out.println("val de idtopo====="+idtopo);

                    managerFactory.getSiteManager().miseajour(tpsite);

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
            site = managerFactory.getSiteManager().getbyID(idsite);
            System.out.println("valeur de site dnas else"+site.toString());
        }
        return resultat;
    }

}
