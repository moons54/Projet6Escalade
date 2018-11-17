package org.topo.projetp6.managerimpl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bean.topo.projetp6.Voie;
import org.bean.topo.projetp6.exception.FunctionalException;
import org.springframework.transaction.PlatformTransactionManager;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.topo.projetp6.impl.dao.VoieDao;
import org.topo.projetp6.manager.AbstractManager;
import org.topo.projetp6.manager.VoieManager;


import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

@Named
public class VoieManagerimpl extends AbstractManager implements VoieManager {
    private static final Logger LOGGER=(Logger) LogManager.getLogger(TopoManagerimpl.class);

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
    public void ajoutevoie(final Voie voie, final Integer idsecteur) throws FunctionalException {
        Set<ConstraintViolation<Voie>> vViolations = getConstraintValidator().validate(voie);
        if(!vViolations.isEmpty()) {
            for (ConstraintViolation<Voie> violation : vViolations) {
                LOGGER.info((violation.getMessage()));
            }
            throw new FunctionalException("Element a completer.");
        }
        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                voieDao.ajoutevoie(voie,idsecteur);
            }

        });

    }

    @Override
    public void miseajour(final Voie voie) {
        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                voieDao.misajour(voie);
            }
        });
    }



    @Override
    public Voie getbynid(int id) {

        return voieDao.getnid(id);
    }


}
