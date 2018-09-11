package org.topo.projetp6.managerimpl;

import org.bean.topo.projetp6.Utilisateur;
import org.topo.projetp6.manager.UtilisateurManager;
import org.bean.topo.projetp6.Message;


import java.util.List;

public class UtilisateurManagerimpl implements UtilisateurManager {

    public Utilisateur getUtilisateur(int Id) {
        if (Id == 0) {
            System.out.print(" Utilisateur non trouvé " + Id);
        }
        Utilisateur utilisateur = new Utilisateur(Id);
        utilisateur.setNom("nom" + Id);


        return utilisateur;
    }

    public Utilisateur affichemessageUtilisateur(int Id) {
        if (Id == 0) {
            System.out.print("pas d'utilsateur selectionné");
        }
        Utilisateur utilisateur=new Utilisateur(Id);
        utilisateur.getMessage().toString().indexOf(Id);


        {


        }

        return utilisateur;
    }

    @Override
    public List<Utilisateur> affichelesUtilisateurs() {
        return null;
    }
}
