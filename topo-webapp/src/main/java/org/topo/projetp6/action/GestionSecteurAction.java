package org.topo.projetp6.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.bean.topo.projetp6.Secteur;
import org.bean.topo.projetp6.Site;
import org.bean.topo.projetp6.Topo;
import org.topo.projetp6.impl.dao.SecteurDaoimpl;
import org.topo.projetp6.impl.dao.SiteDaoimpl;

import org.topo.projetp6.impl.dao.TopoDaoImpl;
import org.topo.projetp6.manager.ManagerFactory;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.NoSuchElementException;

public class GestionSecteurAction extends ActionSupport {

    private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionSecteurAction.class);



    @Inject
    private ManagerFactory managerFactory;


    /**
     * Lien entre les actions et la bd
     */

    //les entrées et les sorties

    // les entrées

    private Integer idsite;
    private Integer idsecteur;

    public Site site;



     //Les sorties
    private List<Secteur> affichelistsecteurs;


    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    private Secteur secteur;





    private SiteDaoimpl sitedao;
    private SecteurDaoimpl secteurDao;



    //les Getters et les Setters

        //affiche la liste des secteurs

    public List<Secteur> getAffichelistsecteurs() {
        return affichelistsecteurs;
    }

    public void setAffichelistsecteurs(List<Secteur> affichelistsecteurs) {
        this.affichelistsecteurs = affichelistsecteurs;
    }

    public Integer getIdsecteur() {
        return idsecteur;
    }

    public void setIdsecteur(Integer idsecteur) {
        this.idsecteur = idsecteur;
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

        affichelistsecteurs= managerFactory.getSecteurManager().affichelesecteur(idsite);

return ActionSupport.SUCCESS;
    };
    //methode permettant de crée un nouveau TOPO
    public String doCreate(){
LOGGER.info("Methode doCreate de sectaction");
        String vresult = ActionSupport.INPUT;

        //condition validant l'ajout de formulaire

        if (this.secteur !=null)
        {
            if (this.secteur.getNomSecteur() == null)
            {
                this.addFieldError(" topo.nom", "ne peut pas etre vide");
            } else

            {


                this.secteur.setiD(idsecteur);
            }if (!this.hasErrors())

        {
            try
            {
                managerFactory.getSecteurManager().ajoutesecteur(this.secteur,idsecteur);
                vresult = ActionSupport.SUCCESS;
                this.addActionMessage("Nouveau Secteur consultable et pret a l'emploi");
            } catch (Exception e)
            {

                vresult = ActionSupport.ERROR;
            }

        }
        }

        return vresult;
    };


    public String doDetail(){
        //gestion des erreurs si id du topo null
        if(idsecteur==null){
            this.addActionError(getText("error.topo.missing.id."));
        }else secteur = managerFactory.getSecteurManager().getbynid(idsecteur);
        {
             // this.addActionError("il n'y a pas de projet pour ce numéro "+idtopo );


        }
return (this.hasErrors())? ActionSupport.ERROR : ActionSupport.SUCCESS;

    }



    public String doSupp(){
String vresult=ActionSupport.INPUT;
        if (idsecteur == null) {
            this.addActionError(getText("error.topo.missing.id"));
        }else  managerFactory.getSecteurManager().supprimesecteur(this.idsecteur);
        vresult= ActionSupport.SUCCESS;
        this.addActionMessage("le secteur a bien été supprimé avec succes");

        {
    }
return vresult;
};

    public String doModif() {

        String resultat = ActionSupport.INPUT;

        if (this.secteur != null) {
            if (this.secteur.getNom() != null) {
                try {
                    // Le formulaire a été envoyé, afin d'éviter la manipulation des données via le navigateur, on instancie un Topo temporaire
                    // Ainsi l'id est non modifiable.
                    Secteur tpsecteur = managerFactory.getSecteurManager().getbynid(secteur.getiD());
                    tpsecteur.setNom(secteur.getNom());
                    tpsecteur.setNombreVoie(secteur.getNombreDevoie());
                    tpsecteur.setiD(idsecteur);
                    tpsecteur.setDifficulte(secteur.getDifficulte());






                    managerFactory.getSecteurManager().miseajour(tpsecteur);
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
            secteur = managerFactory.getSecteurManager().getbynid(idsecteur);
        }
        return resultat;
    }

}
