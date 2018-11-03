package org.topo.projetp6.managerimpl;

import org.bean.topo.projetp6.Utilisateur;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.topo.projetp6.impl.dao.UtilisateurDao;
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


    @Inject
    private UtilisateurDao utilisateurDao;

    public Utilisateur getUtilisateur(int Id) {
       Utilisateur utilisateur= getDaoFactory().getUtilisateurDao().getbyID(Id);
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

        return vutil;
    }

    @Override
    public void miseajour(final Utilisateur utilisateur){
        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                utilisateurDao.misajourutilisateur(utilisateur);
            }
        });


    }

    @Override
    public void supprimeUtilisateur(final int Id){
        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                utilisateurDao.supprimeUtilisateur(Id);
            }
        });

    }

    @Override
    public void ajoututilisateur(final Utilisateur utilisateur){
        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                utilisateurDao.ajoututilisateur(utilisateur);
            }
        });


    }
}
