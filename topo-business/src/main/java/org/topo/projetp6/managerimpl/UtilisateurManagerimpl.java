package org.topo.projetp6.managerimpl;

import org.bean.topo.projetp6.Utilisateur;

import org.springframework.transaction.PlatformTransactionManager;
import org.topo.projetp6.manager.AbstractManager;
import org.topo.projetp6.manager.UtilisateurManager;
import org.bean.topo.projetp6.Message;
import org.bean.topo.projetp6.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class UtilisateurManagerimpl extends AbstractManager implements UtilisateurManager {

    @Inject
    @Named("TXtransactionTOPO")
    private PlatformTransactionManager platformTransactionManager;

    private List<Utilisateur> listut=new ArrayList<Utilisateur>();


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
    public List<Utilisateur> affichelesUtilisateurs(){
         listut= getDaoFactory().getUtilisateurDao().listutilisateur();
    return listut ;
    }

    @Override
    public Utilisateur getuserpassword(final String user, final String password) throws NotFoundException {
        System.out.println(" dans le stream");
        List<Utilisateur> utillist = this.affichelesUtilisateurs();
        Utilisateur vutil = utillist.stream()
                .filter(p-> p.getNom().equals(user))
                .filter(p->p.getMotDePasse().equals(password))
                .findFirst()
                .orElseThrow(()-> new NotFoundException("pas d'utilisateur trouvé"));




      //  Utilisateur utilisateur=getDaoFactory().getUtilisateurDao().getbyuserpass(user,password);
       // System.out.println("val de ut" +utilisateur);
        System.out.println("val de getuser"+vutil);
        return vutil;
    }
}
