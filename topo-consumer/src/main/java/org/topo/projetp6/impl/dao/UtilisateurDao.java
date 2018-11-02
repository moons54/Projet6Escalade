package org.topo.projetp6.impl.dao;

import org.bean.topo.projetp6.Utilisateur;

import java.util.List;

public interface UtilisateurDao {



    public Utilisateur getbyID(int Id);

    public Utilisateur getbyuserpass(String nom,String motdepasse);

    public List<Utilisateur> listutilisateur();
}
