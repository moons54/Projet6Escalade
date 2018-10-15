package org.topo.projetp6.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.bean.topo.projetp6.Topo;
import org.bean.topo.projetp6.Voie;
import org.topo.projetp6.manager.ManagerFactory;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.NoSuchElementException;

public class GestionVoieAction extends ActionSupport {


    @Inject
    private ManagerFactory managerFactory;


    //GESTION DES ENTREES
    private Integer idsecteur;
    private Integer idvoie;


    //GESTION DES SORTIES
    private Voie voie;
    private List<Voie> affichelesvoies;


    //LES GETTERS ET LES SETTERS


    public Integer getIdsecteur() {
        return idsecteur;
    }

    public void setIdsecteur(Integer idsecteur) {
        this.idsecteur = idsecteur;
    }

    public Integer getIdvoie() {
        return idvoie;
    }

    public void setIdvoie(Integer idvoie) {
        this.idvoie = idvoie;
    }

    public Voie getVoie() {
        return voie;
    }

    public void setVoie(Voie voie) {
        this.voie = voie;
    }

    public List<Voie> getAffichelesvoies() {
        return affichelesvoies;
    }

    public void setAffichelesvoies(List<Voie> affichelesvoies) {
        this.affichelesvoies = affichelesvoies;
    }


    //LES ACTIONS ASSOCIES


    /**
     * Methode do liste renvoie une liste des voies par secteur
     *
     * @return
     */
    public String doList() {
        affichelesvoies = managerFactory.getVoieManager().affichelesvoies(idsecteur);

        return ActionSupport.SUCCESS;
    }

    ;


    /**
     * Methode do detail renvoie l'enregistrement de la voie dependant du secteur selectionné
     *
     * @return
     */
    public String doDetail() {
        //si id du site est null
        if (idvoie == null) {
            this.addActionError(getText("error.topo.missing.id"));
        } else {
            voie = managerFactory.getVoieManager().getbynid(idvoie);
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }


    public String doSupp() {
        String vresult = ActionSupport.INPUT;
        if (this.idvoie == null) {
            this.addActionError(getText("error.topo.missing.id"));
        } else {

            managerFactory.getVoieManager().supprimevoie(idvoie);
            vresult= ActionSupport.SUCCESS;
            this.addActionMessage("la voie a bien été supprimée");
        }
        return vresult;
    }

    ;



    public String doCreate() {
        String vresult = ActionSupport.INPUT;

        if (this.voie != null) {
            if (this.voie.getNomvoie() == null) {
                this.addFieldError("topo.nom", "ne peut pas etre vide");
            } else {
              this.voie.setiD(idvoie);
            }
            if (!this.hasErrors())
            {
                try
                {


                    managerFactory.getVoieManager().ajoutevoie(this.voie,idvoie);
                    vresult = ActionSupport.SUCCESS;
                    this.addActionMessage("nouvelle voie consultable");
                } catch (Exception e)
                    {
                        vresult = ActionSupport.ERROR;
//                      this.addActionError("probleme technique d'enregistrement");
                    }

            }
        }
        return vresult;
    }

    public String doModif() {

        String resultat = ActionSupport.INPUT;

        if (this.voie != null) {
            if (this.voie.getNom() != null) {
                try {
                    // Le formulaire a été envoyé, afin d'éviter la manipulation des données via le navigateur, on instancie un Topo temporaire
                    // Ainsi l'id est non modifiable.
                    Voie tmvoie = managerFactory.getVoieManager().getbynid(voie.getiD());
                    tmvoie.setNomvoie(voie.getNomvoie());
                    tmvoie.setLongueur(voie.getLongueur());
                    tmvoie.setNiveau(voie.getNiveau());
                    tmvoie.setCotation(voie.getCotation());
                    tmvoie.setiD(voie.getiD());


                    managerFactory.getTopoManager().miseajour(tmvoie);
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
            voie = managerFactory.getVoieManager().getbynid(idvoie);
        }
        return resultat;
    }



}