package org.topo.projetp6.managerimpl;
import org.bean.topo.projetp6.Topo;
import org.topo.projetp6.manager.ManagerFactory;
import org.topo.projetp6.manager.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("managerFactory")
public class ManagerFactoryimpl implements ManagerFactory {


    @Inject
    private TopoManager topomanager;


    @Override
    public TopoManager getTopoManager() {
        return this.topomanager;
    }

    public void setTopoManager(TopoManager pTopoManager) {
        topomanager = pTopoManager;
    }
}


