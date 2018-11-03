package org.topo.projetp6.manager;

import org.bean.topo.projetp6.Utilisateur;
import org.topo.projetp6.managerimpl.UtilisateurManagerimpl;
import org.bean.topo.projetp6.exception.NotFoundException;
import java.util.List;

public interface UtilisateurManager {
    //TODO il faut penser a creer des variable et methode sur le principe du camelcase

    public Utilisateur getUtilisateur(int Id);

    Utilisateur affichemessageUtilisateur(int Id);

    /**
     * @return la liste des utilisateurs
     */
    List<Utilisateur> affichelesUtilisateurs();


    Utilisateur getuserpassword(String user,String password) throws NotFoundException;

    public void miseajour(final Utilisateur utilisateur);

    public void supprimeUtilisateur(final int Id);

    public void ajoututilisateur(final Utilisateur utilisateur);


}
