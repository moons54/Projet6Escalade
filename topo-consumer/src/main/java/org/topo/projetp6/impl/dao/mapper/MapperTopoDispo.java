package org.topo.projetp6.impl.dao.mapper;

import org.bean.topo.projetp6.Topo;
import org.bean.topo.projetp6.TopoReservable;
import org.bean.topo.projetp6.Utilisateur;
import org.springframework.jdbc.core.RowMapper;
import org.topo.projetp6.impl.DaoFactory;
import org.topo.projetp6.impl.dao.DaoFactoryImpl;
import org.topo.projetp6.impl.dao.TopoDao;
import org.topo.projetp6.impl.dao.UtilisateurDao;
import org.topo.projetp6.impl.dao.UtilisateurDaoimpl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class MapperTopoDispo implements RowMapper<TopoReservable> {


    @Inject
    UtilisateurDao utilisateurDao;

    @Inject
    DaoFactory daoFactory;



    @Inject
    TopoDao topoDao;


    @Override
    public TopoReservable mapRow(ResultSet rs, int rowNum) throws SQLException {

       // UtilisateurDaoimpl ut= new UtilisateurDaoimpl();

      //DaoFactoryImpl dao=new DaoFactoryImpl();

     //  System.out.println(daoFactory.getTopoDao().affiche());



        TopoReservable mondispo = new TopoReservable(rs.getInt("id"));
        mondispo.setDatedispodebut(rs.getDate("datedispodebut"));
        mondispo.setDatedispofin(rs.getDate("datedispofin"));
        mondispo.setUtilisateur(new Utilisateur(rs.getInt("utilisateurid")));
    //    mondispo.setUtilisateur(daoFactory.getUtilisateurDao().find(rs.getInt("utilisateurid")));
   // mondispo.setTopo((topoDao.find(rs.getInt("topoid"))));
       mondispo.setTopo(new Topo(rs.getInt("topoid")));
        return mondispo;
    }



}
