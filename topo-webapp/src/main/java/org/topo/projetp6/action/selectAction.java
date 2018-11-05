package org.topo.projetp6.action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

public class selectAction extends ActionSupport {

    private List<String> searchEngine;
    private String yourSearchEngine;

    //set default value
    public String getDefaultSearchEngine() {
        return "yahoo.com";
    }

    public selectAction() {
        searchEngine = new ArrayList<String>();
        searchEngine.add("administrateur");
        searchEngine.add("Utilisateur");
        searchEngine.add("Propriétaire");

    }
}