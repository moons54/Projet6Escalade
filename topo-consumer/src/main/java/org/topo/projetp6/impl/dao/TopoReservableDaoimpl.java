package org.topo.projetp6.impl.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bean.topo.projetp6.TopoReservable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.topo.projetp6.impl.dao.mapper.MapperTopoDispo;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.topo.projetp6.impl.dao.mapper.MapperTopoDispo;

@Named
public class TopoReservableDaoimpl extends AbstractDaoImpl implements TopoReservableDao{

    @Inject
    private TopoReservableDao topoReservableDao;

    @Inject
    private UtilisateurDao utilisateurDao;

    private static final Logger LOGGER=(Logger) LogManager.getLogger(TopoReservableDaoimpl.class);


    @Override
    public List<TopoReservable> affichedisponbile() {
        LOGGER.info("Methode affiche liste");
        //Requete SQL dans bd recupperer la liste des topos reservable
        String vSql ="SELECT * FROM public.topo_reservable";
        JdbcTemplate vjdbcTemplate = new JdbcTemplate(getDatasource());
        MapperTopoDispo rowresa = new MapperTopoDispo();

        List<TopoReservable> vListStatut = vjdbcTemplate.query(vSql,rowresa);

        return vListStatut;
    }

    @Override
    public TopoReservable getByiD(int Id) {
        LOGGER.info("Methode getbyid");
    //Requete avec resultat en param id
    String vSql ="SELECT * FROM public.topo_reservable where id=?";

    //Connection a la datasource
    JdbcTemplate vjdbcTemplate = new JdbcTemplate(getDatasource());

    //instanciation du Mappertopodispo
    MapperTopoDispo mapperTopoDispo = new MapperTopoDispo();

    TopoReservable topoReservable=vjdbcTemplate.queryForObject(vSql,mapperTopoDispo,Id);
    return topoReservable;
    }


    @Override
    public TopoReservable retiredesreservables(int Id) {
        LOGGER.info("Methode Suppression d'un topo reservable");
        //Requete pour supprimer un topo reservable
        String vSQL="DELETE from public.topo_reservable where id=?";

        JdbcTemplate vjdbcTemplate = new JdbcTemplate(getDatasource());

        vjdbcTemplate.update(vSQL,Id);
        return null;
    }

    @Override
    public TopoReservable ajoutdesreservables(TopoReservable topoReservable) {
        LOGGER.info("Methode ajouttopreservable");
        String ajoutsql = "INSERT INTO public.topo_reservable" +
                " (datedispodebut,\n" +
                " datedispofin,\n" +
                " topoid,\n" +
                " utilisateurid)" +
                "VALUES" +
                "(:datedispodebut,:datedispofin,:topoid,:utilisateurid)";


        SqlParameterSource ajoututil = new MapSqlParameterSource()
                .addValue("datedispodebut",topoReservable.getDatedispodebut())
                .addValue("datedispofin",topoReservable.getDatedispofin())
                .addValue("topoid",topoReservable.getTopo().getiD())
                .addValue("utilisateurid",topoReservable.getUtilisateur().getiD());


        //Gestion de la clé primaire
        KeyHolder holder = new GeneratedKeyHolder();
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDatasource());
        vJdbcTemplate.update(ajoutsql, ajoututil, holder, new String[]{"id"});
        topoReservable.setiD(holder.getKey().intValue());
        return topoReservable;
    }
    public TopoReservable find(Integer id) {
        LOGGER.info("Methode find");
        String vsql ="SELECT * FROM public.topo_reservable WHERE id=?";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());
        TopoReservable topoReservable=(TopoReservable) vJdbcTemplate.queryForObject(vsql, new Object[] { id }, new MapperTopoDispo());
        if(topoReservable==null) {
            return null;
        }
        return topoReservable;
    }
}
