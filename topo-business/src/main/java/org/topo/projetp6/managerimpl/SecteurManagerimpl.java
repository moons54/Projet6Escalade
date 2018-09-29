package org.topo.projetp6.managerimpl;

import org.bean.topo.projetp6.Secteur;
import org.springframework.transaction.PlatformTransactionManager;
import org.topo.projetp6.impl.dao.SecteurDAO;
import org.topo.projetp6.manager.AbstractManager;
import org.topo.projetp6.manager.SecteurManager;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SecteurManagerimpl extends AbstractManager implements SecteurManager {

    /**
     * insertion de l'objet dao des Secteurs
     */

    @Inject
    private SecteurDAO secteurDAO;

    @Inject
    @Named("TXtransactionTOPO")
    private PlatformTransactionManager platformTransactionManager;

   @Override
    public List<Secteur> affichelesecteur(int idsite) {
        return secteurDAO.affiche(idsite);
    }

    @Override
    public Secteur getbyID(int Id) {

       Secteur secteur=  secteurDAO.getbyiD(Id);
       return secteur;
    }

    @Override
    public Secteur getbynid(int idsecteur) {
        //Secteur secteur= secteurDAO.getnid(idsecteur);
        return secteurDAO.getnid(idsecteur);
    }


}
