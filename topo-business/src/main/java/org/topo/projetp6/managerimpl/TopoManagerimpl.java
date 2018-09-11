package org.topo.projetp6.managerimpl;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.topo.projetp6.impl.dao.TopoDao;
import org.topo.projetp6.manager.AbstractManager;
import org.topo.projetp6.manager.TopoManager;
import org.bean.topo.projetp6.Topo;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Iterator;
import java.util.List;

@Named
public class TopoManagerimpl extends AbstractManager implements TopoManager {

    /**
     * insertion de l'objet dao des topos
     */

    @Inject
    private TopoDao topoDao;

    @Inject
    @Named("TXtransactionTOPO")
    private PlatformTransactionManager platformTransactionManager;

    /**
     * Methode retournant un topo
     *
     * @param Id
     * @return le topo selectionné
     *
     */
    @Override
    public Topo getTopo(int Id) {
      //  if(Id==0){
        //            System.out.print(" Topo non trouvé "+ Id);
       // }
        Topo tops = new Topo(Id);






        tops.setNom(affichelistedestopos().get(Id).getNom());
        tops.setDescriptiondestopo(affichelistedestopos().get(Id).getDescriptiondestopo());
        tops.setTypeDequipement(affichelistedestopos().get(Id).getTypeDequipement());
        tops.setHauteurDuTopo(affichelistedestopos().get(Id).getHauteurDuTopo());
        tops.setHistoriquedestopo(affichelistedestopos().get(Id).getHistoriquedestopo());
        tops.setNombreDevoie(affichelistedestopos().get(Id).getNombreDevoie());
        tops.setDescriptionDuRetour(affichelistedestopos().get(Id).getDescriptionDuRetour());
        tops.setTypeDeroche(affichelistedestopos().get(Id).getTypeDeroche());




        return tops;


    }


    /**
     * methode renvoyant la liste des topos
     * nous appelons le l'objet topo dao pour l'appeler
     * @return
     */
    @Override
    public List<Topo> affichelistedestopos(){
     return topoDao.affiche();

    }

    /**
     * ajout d'un nouveau topo
     * @param topo
     */

    @Override
    public Topo ajoutopo(final Topo topo){
        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                topoDao.ajoutopo(topo);
            }
        });

        return topo;
    }





}
