package org.topo.projetp6.action;

import com.opensymphony.xwork2.ActionSupport;
import org.bean.topo.projetp6.Secteur;
import org.bean.topo.projetp6.Topo;
import org.topo.projetp6.impl.dao.SecteurDaoimpl;
import org.topo.projetp6.impl.dao.SiteDaoimpl;

import org.topo.projetp6.impl.dao.TopoDaoImpl;
import org.topo.projetp6.manager.ManagerFactory;

import javax.inject.Inject;
import java.util.List;

public class GestionSecteurAction extends ActionSupport {




    @Inject
    private ManagerFactory managerFactory;


    /**
     * Lien entre les actions et la bd
     */

    //les entrées et les sorties

    // les entrées

    private Integer idsite;
    private Integer idsecteur;





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
/**
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

*/
    public String doDetail(){
        //gestion des erreurs si id du topo null
        if(idsecteur==null){
          System.out.println("valeur "+getIdsecteur() +"  "+ getIdsite()+"  3 eme val" );
            this.addActionError(getText("error.topo.missing.id."));
        }else secteur = managerFactory.getSecteurManager().getbynid(idsecteur);
      // System.out.println(secteur.getNomSecteur().toString());
     //   System.out.println("valeur "+getIdsecteur() +"  "+ getIdsite()+"  3 eme val" + getIdtopo()+secteur.toString());
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
}
