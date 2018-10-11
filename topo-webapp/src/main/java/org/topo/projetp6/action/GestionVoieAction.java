package org.topo.projetp6.action;

import com.opensymphony.xwork2.ActionSupport;
import org.bean.topo.projetp6.Voie;
import org.topo.projetp6.manager.ManagerFactory;

import javax.inject.Inject;
import java.util.List;

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
        if (idvoie == null) {
            this.addActionError(getText("error.topo.missing.id"));
        } else {

            managerFactory.getVoieManager().supprimevoie(idvoie);
            this.addActionMessage("la voie a bien été supprimée");
        }
        return vresult;
    }

    ;


    //TODO reste a creer l'action creer une voie
    public String doCreate() {
        String vresult = ActionSupport.INPUT;

        if (this.voie != null) {
            if (this.voie.getNomvoie() == null) {
                this.addFieldError("topo.nom", "ne peut pas etre vide");
            } else {
                System.out.println("ok pour voie");
            }
            if (!this.hasErrors()) {
                try {
                    //TODO il manque la creation de la methode creer a appeler
                    managerFactory.getVoieManager();
                    vresult = ActionSupport.SUCCESS;
                    this.addActionMessage("nouvelle voie consultable");
                } catch (Exception e) {
                    vresult = ActionSupport.ERROR;
//                    this.addActionError("probleme technique d'enregistrement");
                }

            }
        }
        return vresult;
    }

    ;



}