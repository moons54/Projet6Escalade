package org.topo.projetp6.action;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.bean.topo.projetp6.Utilisateur;
import org.topo.projetp6.manager.ManagerFactory;
import org.bean.topo.projetp6.exception.NotFoundException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class loginAction extends ActionSupport implements SessionAware {
    private static final Logger LOGGER=(Logger) LogManager.getLogger(loginAction.class);


    @Inject
    private ManagerFactory managerFactory;



    //Elements Struts
    private Map<String,Object> session;


    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }





    //Attributs
    //param en entrée
    private String user;
    private String password;
    private Utilisateur utilisateur;
    private Integer idutilisateur;
    private List<String> searchEngine;
    private String yourSearchEngine;

    public List getRrole() {
        return rrole;
    }

    public void setRrole(List rrole) {
        this.rrole = rrole;
    }

    private List rrole;



    private List<Utilisateur> afficheutil;
    //GETTERS ET SETTERS

    public Integer getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Integer idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Utilisateur> getAfficheutil() {
        return afficheutil;
    }

    public void setAfficheutil(List<Utilisateur> afficheutil) {
        this.afficheutil = afficheutil;
    }



    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getSearchEngine() {
        return searchEngine;
    }

    public void listerrole(){
        rrole.add(1);
        rrole.add(2);
        rrole.add(3);
    }
    //Methodes associés


    public String doLogin(){
        System.out.println("dans ");
        LOGGER.debug("dans l'action dologin");
        String vResult=ActionSupport.INPUT;
        if (!StringUtils.isAllEmpty(user,password)){
            System.out.println("essais dedans");
            System.out.println("val " +user +"et" +password);
            try {
                utilisateur = managerFactory.getUtilisateurManager().getuserpassword(user,password);
            //    System.out.println(" la valeur du pass" +managerFactory.getUtilisateurManager().getuserpassword(user,password));
                //Ajout de la session de l'utilisateur


                this.session.put("user",utilisateur);
                this.addActionMessage("vous etes connecté");
                vResult=ActionSupport.SUCCESS;
            } catch (NotFoundException pEx){
                this.addActionError("identification ou mot de passe Erronée");
            }
        }
        return vResult;
    }

    public String doLogout(){
        //l'utilisateur n'est plus présent dans la session
        this.session.remove("user");
        return ActionSupport.SUCCESS;
    }





    public String doCreate(){
        String vresult = ActionSupport.INPUT;

        //condition validant l'ajout de formulaire

        if (this.utilisateur !=null) {

            if (this.utilisateur.getNom() == null) {
                this.addFieldError(" topo.nom", "ne peut pas etre vide");

            } else
            {

                System.out.println("ok");
            }



            if (!this.hasErrors())
            {
                try
                {
                    managerFactory.getUtilisateurManager().ajoututilisateur(this.utilisateur);

                    vresult = ActionSupport.SUCCESS;
                    this.addActionMessage("bienvenue");
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
        if(idutilisateur==null){
            this.addActionError(getText("error.topo.missing.id."));
        }else
          utilisateur  =managerFactory.getUtilisateurManager().getUtilisateur(idutilisateur);
        {
            // this.addActionError("il n'y a pas de projet pour ce numéro "+idtopo );


        }
        return (this.hasErrors())? ActionSupport.ERROR : ActionSupport.SUCCESS;

    };




    public String doList(){

        afficheutil= managerFactory.getUtilisateurManager().affichelesUtilisateurs();
        return ActionSupport.SUCCESS;
    };



    public String doSupp(){
        String vresult=ActionSupport.INPUT;
        if (idutilisateur == null) {
            this.addActionError(getText("error.topo.missing.id"));
        }else  managerFactory.getUtilisateurManager().supprimeUtilisateur(this.idutilisateur);
        vresult= ActionSupport.SUCCESS;
        this.addActionMessage("topo a bien été supprimé avec succes");

        {
        }
        return vresult;
    };


    public String doModif() {

        String resultat = ActionSupport.INPUT;

        if (this.utilisateur != null) {
            if (this.utilisateur.getNom() != null) {
                try {
                    // Le formulaire a été envoyé, afin d'éviter la manipulation des données via le navigateur, on instancie un Topo temporaire
                    // Ainsi l'id est non modifiable.
                    Utilisateur tmputil = managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getiD());
                    tmputil.setIdentifiant(utilisateur.getIdentifiant());
                    tmputil.setMotDePasse(utilisateur.getMotDePasse());
                    tmputil.setNom(utilisateur.getNom());
                    tmputil.setPrenom(utilisateur.getPrenom());
                    tmputil.setEmail(utilisateur.getEmail());
                    tmputil.setLangue(utilisateur.getLangue());
                   tmputil.setRole(utilisateur.getRole());
                    tmputil.setiD(utilisateur.getiD());


                    managerFactory.getUtilisateurManager().miseajour(tmputil);
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
            utilisateur = managerFactory.getUtilisateurManager().getUtilisateur(idutilisateur);
        }
        return resultat;
    }



}
