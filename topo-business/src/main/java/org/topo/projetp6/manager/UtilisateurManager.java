package org.topo.projetp6.manager;

import org.bean.topo.projetp6.Utilisateur;
import org.topo.projetp6.managerimpl.UtilisateurManagerimpl;

import java.util.List;

public interface UtilisateurManager {

    Utilisateur getUtilisateur(int Id);

    Utilisateur affichemessageUtilisateur(int Id);

    /**
     * @return la liste des utilisateurs
     */
    List<Utilisateur> affichelesUtilisateurs();

}
