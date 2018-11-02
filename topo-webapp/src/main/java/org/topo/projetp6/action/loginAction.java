package org.topo.projetp6.action;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.bean.topo.projetp6.Utilisateur;
import org.topo.projetp6.manager.ManagerFactory;
import org.bean.topo.projetp6.exception.NotFoundException;

import javax.inject.Inject;
import java.util.Map;

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
    //GETTERS ET SETTERS

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
}
