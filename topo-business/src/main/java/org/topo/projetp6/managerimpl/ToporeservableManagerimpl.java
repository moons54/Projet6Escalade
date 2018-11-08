package org.topo.projetp6.managerimpl;

import org.bean.topo.projetp6.Topo;
import org.bean.topo.projetp6.TopoReservable;
import org.bean.topo.projetp6.Utilisateur;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.topo.projetp6.impl.dao.TopoDao;
import org.topo.projetp6.impl.dao.TopoDaoImpl;
import org.topo.projetp6.impl.dao.TopoReservableDao;
import org.topo.projetp6.impl.dao.UtilisateurDao;
import org.topo.projetp6.manager.AbstractManager;
import org.topo.projetp6.manager.ToporeservableManager;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class ToporeservableManagerimpl extends AbstractManager implements ToporeservableManager {

    private List<TopoReservable> listdispo=new ArrayList<TopoReservable>();


    @Inject
    private TopoReservableDao topoReservableDao;

    @Inject
    private UtilisateurDao utilisateurDao;

    @Inject
    private TopoDao topoDao;

    @Inject
    private TopoDaoImpl ttdaoim;



    @Inject
    @Named("TXtransactionTOPO")
    private PlatformTransactionManager platformTransactionManager;


    @Override
    public List<TopoReservable> affichelestoposempruntable() {

        listdispo=getDaoFactory().getTopoReservableDao().affichedisponbile();
      //  System.out.println("valeur de resa"+listdispo);
        List<Topo> tops=getDaoFactory().getTopoDao().affiche();
        System.out.println("valeur de tops"+tops);
        List<Utilisateur> utilisateurList=getDaoFactory().getUtilisateurDao().listutilisateur();

        for(TopoReservable r: listdispo){
            for(Topo t: tops){
                if (r.getTopo().getiD()==(t.getiD())){

                    r.setTopo(t);
                  //  System.out.println("ds la bcle"+r.toString());
                }

            }
            for(Utilisateur u:utilisateurList)
                if (r.getUtilisateur().getiD()==(u.getiD())){

                    r.setUtilisateur(u);
                    //System.out.println("ds la bcle"+r.toString());
                }

        }

        /**
        for (int i = 0; i <=listdispo.size(); i++) {
            listdispo.stream().filter(listdispo -> listdispo.getTopo() = Tops.stream()
            .filter(topo -> topo.getNom());


        }
      /**
        TopoReservable reservable = reservableslist.stream()
                .forEach(p-> p.getTopo().setiD(Tops.get(p.getiD())))
                .filter(p->p.getMotDePasse().equals(password))
                .findFirst()
*/
        System.out.println(listdispo.toString());
        return listdispo;
    }

    @Override
    public TopoReservable getTopoByid(int Id) {

        List<Topo> tops= topoDao.affiche();
        TopoReservable dispo = topoReservableDao.getByiD(Id);
       List <Utilisateur> utilisateur=utilisateurDao.listutilisateur();



            for(Topo t: tops){

                if (t.getiD()==dispo.getTopo().getiD()){

                    dispo.setTopo(t);
                    System.out.println("ds la bcle"+dispo.toString());
                }

            }
            for(Utilisateur u: utilisateur)
                if (u.getiD()==dispo.getUtilisateur().getiD()){

                    dispo.setUtilisateur(u);
                    System.out.println("ds la bcle"+dispo.toString());
                }


        System.out.println("valeur de dispo"+dispo);
        return dispo;
    }

    @Override
    public void ajoutopodisponible(TopoReservable topoReservable) {
        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
               topoReservableDao.ajoutdesreservables(topoReservable);
            }
        });
    }

    @Override
    public void retiretopodisponible(int Id) {
        TransactionTemplate rtransactionTemplate = new TransactionTemplate(platformTransactionManager);
        rtransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                topoReservableDao.retiredesreservables(Id);
            }
        });
    }

    @Override
    public void misajour(TopoReservable topoReservable) {

    }
}
