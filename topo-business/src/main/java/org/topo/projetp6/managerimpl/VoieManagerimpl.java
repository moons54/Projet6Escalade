package org.topo.projetp6.managerimpl;


import org.bean.topo.projetp6.Voie;
import org.springframework.transaction.PlatformTransactionManager;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.topo.projetp6.impl.dao.VoieDao;
import org.topo.projetp6.manager.AbstractManager;
import org.topo.projetp6.manager.VoieManager;


import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class VoieManagerimpl extends AbstractManager implements VoieManager {

    /**
     * insertion de l'objet dao des Voie
     */

    @Inject
    private VoieDao voieDao;

    @Inject
    @Named("TXtransactionTOPO")
    private PlatformTransactionManager platformTransactionManager;

     @Override
    public List<Voie> affichelesvoies(int idsecteur) {
        return voieDao.affiche(idsecteur);
    }

    @Override
    public Voie supprimevoie(final int Id) {
         TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                voieDao.supprimevoie(Id);
            }

        });
        return null;
    }

    @Override
    public void ajoutevoie(final Voie voie, final Integer idsecteur) {
        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                voieDao.ajoutevoie(voie,idsecteur);
            }

        });

    }


    @Override
    public Voie getbynid(int id) {

        return voieDao.getnid(id);
    }


}
