package org.topo.projetp6.action;

import com.opensymphony.xwork2.ActionSupport;
import javassist.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.bean.topo.projetp6.*;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.bean.topo.projetp6.Topo;
import org.topo.projetp6.impl.dao.TopoDaoImpl;
import org.topo.projetp6.manager.ManagerFactory;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;

public class GestionTopoAction extends ActionSupport {

    private static final Logger LOGGER=(Logger) LogManager.getLogger(GestionTopoAction.class);



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

    private List<Message> affichecommentaire;

private Message message;

    private Topo topo;

    private TopoDaoImpl tpdao;

    private String voienb;

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

    public List<Message> getAffichecommentaire() {
        return affichecommentaire;
    }

    public void setAffichecommentaire(List<Message> affichecommentaire) {
        this.affichecommentaire = affichecommentaire;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getVoienb() {
        return voienb;
    }

    public void setVoienb(String voienb) {
        this.voienb = voienb;
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

     //condition validant l'ajout de formulaire

        if (this.topo !=null) {

            if (this.topo.getNom() == null) {
                this.addFieldError(" topo.nom", "ne peut pas etre vide");

            } else
                    {

                        System.out.println("ok");
                     }



                    if (!this.hasErrors())
                    {
                        try
                        {
                            managerFactory.getTopoManager().ajoutopo(this.topo);

                            vresult = ActionSupport.SUCCESS;
                            this.addActionMessage("Nouveau Topo consultable et pret a l'emploi");
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
        if(idtopo==null){
            this.addActionError(getText("error.topo.missing.id."));
        }else topo = managerFactory.getTopoManager().getTopo(idtopo);
        affichecommentaire=managerFactory.getMessageManager().affichepartopo(idtopo);
        System.out.println("voir si ça apparait"+affichecommentaire.toString());
        {
             // this.addActionError("il n'y a pas de projet pour ce numéro "+idtopo );


        }
return (this.hasErrors())? ActionSupport.ERROR : ActionSupport.SUCCESS;

    };



    public String doSupp(){
String vresult=ActionSupport.INPUT;
        if (idtopo == null) {
            this.addActionError(getText("error.topo.missing.id"));
        }else  managerFactory.getTopoManager().supprimetopo(this.idtopo);
        vresult= ActionSupport.SUCCESS;
        this.addActionMessage("topo a bien été supprimé avec succes");

        {
    }
return vresult;
};
    public String doModif() {

        String resultat = ActionSupport.INPUT;

        if (this.topo != null) {
            if (this.topo.getNom() != null) {
                try {
                    // Le formulaire a été envoyé, afin d'éviter la manipulation des données via le navigateur, on instancie un Topo temporaire
                    // Ainsi l'id est non modifiable.
                    Topo tmpTopo = managerFactory.getTopoManager().getTopo(topo.getiD());
                    tmpTopo.setNom(topo.getNom());
                    tmpTopo.setDescriptiondestopo(topo.getDescriptiondestopo());
                    tmpTopo.setHistoriquedestopo(topo.getHistoriquedestopo());
                    tmpTopo.setHauteurDuTopo(topo.getHauteurDuTopo());
                    tmpTopo.setTypeDeroche(topo.getTypeDeroche());
                    tmpTopo.setNombreDevoie(topo.getNombreDevoie());
                    tmpTopo.setDescriptionDuRetour(topo.getDescriptionDuRetour());
                    tmpTopo.setTypeDequipement(topo.getTypeDequipement());
                    tmpTopo.setPhotoDuTopo(topo.getPhotoDuTopo());
                 tmpTopo.setiD(topo.getiD());


                    managerFactory.getTopoManager().miseajour(tmpTopo);
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
            topo = managerFactory.getTopoManager().getTopo(idtopo);
        }
        return resultat;
    }


    //methode permettant de crée un nouveau TOPO
    public String doRecherche(){
        String vresult = ActionSupport.INPUT;

        //condition validant l'ajout de formulaire

        if (this.topo !=null) {

            if (this.topo.getTypeDeroche() == null) {
                this.addFieldError(" topo.nom", "ne peut pas etre vide");

            } else
            {

                System.out.println("ok");
            }



            if (!this.hasErrors())
            {
                try
                {
                  affichelistetopo=  managerFactory.getTopoManager().recherchemulticritere(topo.getTypeDeroche(),topo.getNiveau());

                    vresult = ActionSupport.SUCCESS;
                    this.addActionMessage("liste des topo concernés");
                } catch (Exception e)
                {

                    vresult = ActionSupport.ERROR;
                }

            }
        }

        return vresult;
    };


}

