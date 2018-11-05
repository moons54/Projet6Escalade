package org.topo.projetp6.impl.dao.mapper;

import org.bean.topo.projetp6.TopoReservable;
import org.springframework.jdbc.core.RowMapper;
import org.topo.projetp6.impl.dao.TopoDao;
import org.topo.projetp6.impl.dao.UtilisateurDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperTopoDispo implements RowMapper<TopoReservable> {

    UtilisateurDao utilisateurDao;

    TopoDao topoDao;

    @Override
    public TopoReservable mapRow(ResultSet rs, int rowNum) throws SQLException {

        TopoReservable mondispo = new TopoReservable(rs.getInt("id"));
        mondispo.setDatedispodebut(rs.getDate("datedispodebut"));
        mondispo.setDatedispofin(rs.getDate("datedispofin"));
        mondispo.setUtilisateur(utilisateurDao.find(rs.getInt("utilisateurid")));
        mondispo.setTopo((topoDao.find(rs.getInt("topoid"))));
        return mondispo;
    }

}
