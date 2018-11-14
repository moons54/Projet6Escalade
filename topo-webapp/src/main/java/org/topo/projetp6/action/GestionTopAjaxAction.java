package org.topo.projetp6.action;

import com.opensymphony.xwork2.ActionSupport;
import org.bean.topo.projetp6.Site;
import org.bean.topo.projetp6.Topo;
import org.topo.projetp6.manager.ManagerFactory;

import javax.inject.Inject;
import java.util.List;

public class GestionTopAjaxAction extends ActionSupport {


    @Inject
    ManagerFactory managerFactory;


    //Elements en sortie

    private List<Topo> topoList;

    private List<Site> siteList;

    private Topo topo;


    //GETTER ET SETTER

    public List<Topo> getTopoList() {
        return topoList;
    }

    public void setTopoList(List<Topo> topoList) {
        this.topoList = topoList;
    }

    public List<Site> getSiteList() {
        return siteList;
    }

    public void setSiteList(List<Site> siteList) {
        this.siteList = siteList;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }
//METHODE

    public String execute() {
        topoList=managerFactory.getTopoManager().affichelistedestopos();
        return ActionSupport.SUCCESS;
    }


    public String doAjaxGetlistTopo() {
        topoList = managerFactory.getTopoManager().affichelistedestopos();
        return ActionSupport.SUCCESS;
    }

    public String doAjaxgetlistSite() {
        if (topo == null) {
            addActionError("le topo doit etre précisé");
        } else {
            siteList = (List<Site>) managerFactory.getSiteManager().getbyID(topo.getiD());
        }
        return hasErrors() ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
}
