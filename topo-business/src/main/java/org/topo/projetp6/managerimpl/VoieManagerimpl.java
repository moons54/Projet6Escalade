package org.topo.projetp6.managerimpl;


import org.bean.topo.projetp6.Voie;
import org.springframework.transaction.PlatformTransactionManager;

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
    public Voie getbynid(int id) {
        //Secteur secteur= secteurDAO.getnid(idsecteur);
        return voieDao.getnid(id);
    }


}
