package org.topo.projetp6.impl.dao.mapper;

import org.bean.topo.projetp6.Reservation;

import org.bean.topo.projetp6.TopoReservable;
import org.bean.topo.projetp6.Utilisateur;
import org.springframework.jdbc.core.RowMapper;
import org.topo.projetp6.impl.dao.TopoReservableDao;
import org.topo.projetp6.impl.dao.UtilisateurDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperReservation implements RowMapper<Reservation> {

    UtilisateurDao utilisateurDao;

    TopoReservableDao topoReservableDao;

    public Reservation mapRow(ResultSet rs,int rowNum) throws SQLException {

        Reservation maresa = new Reservation(rs.getInt("id"));
        maresa.setDateReservationDebut(rs.getDate("datereservationdebut"));
        maresa.setDateReservationFin(rs.getDate("datereservationfin"));
        maresa.setUtilisateur(utilisateurDao.find(rs.getInt("utilisateurid")));
        maresa.setTopoReservable(topoReservableDao.find(rs.getInt("topo_reservableid")));
    return maresa;

    }

}
