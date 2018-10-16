package org.topo.projetp6.impl.dao;

import org.bean.topo.projetp6.Utilisateur;

public interface UtilisateurDao {



    public Utilisateur getbyID(int Id);

    public Utilisateur getbyuserpass(String nom,String motdepasse);

}
