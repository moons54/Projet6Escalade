package org.topo.projetp6.managerimpl;

import org.bean.topo.projetp6.Utilisateur;
import org.springframework.transaction.PlatformTransactionManager;
import org.topo.projetp6.manager.AbstractManager;
import org.topo.projetp6.manager.UtilisateurManager;
import org.bean.topo.projetp6.Message;


import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

public class UtilisateurManagerimpl extends AbstractManager implements UtilisateurManager {

    @Inject
    @Named("TXtransactionTOPO")
    private PlatformTransactionManager platformTransactionManager;




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

    @Override
    public Utilisateur getuserpassword(String user, String password) {
        Utilisateur utilisateur=getDaoFactory().getUtilisateurDao().getbyuserpass(user,password);
        return utilisateur;
    }
}
