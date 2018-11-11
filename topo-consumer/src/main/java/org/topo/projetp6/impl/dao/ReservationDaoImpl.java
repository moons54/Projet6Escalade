package org.topo.projetp6.impl.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bean.topo.projetp6.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.topo.projetp6.impl.dao.mapper.MapperReservation;

import javax.inject.Inject;
import javax.inject.Named;

import java.util.Date;
import java.util.List;

@Named
public class ReservationDaoImpl extends AbstractDaoImpl implements ReservationDao {



    @Inject
    private UtilisateurDao utilisateurDao;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final Logger LOGGER=(Logger) LogManager.getLogger(ReservationDaoImpl.class);


   // @Override
    public List<Reservation> listedesreservation() {
        LOGGER.info("Methode lise des reservations");

        String vSQL="SELECT * FROM public.reservation";

        JdbcTemplate vjdbcTemplate = new JdbcTemplate(getDatasource());

        RowMapper<Reservation> maresa = new MapperReservation();

        List<Reservation> vlistStatut = vjdbcTemplate.query(vSQL,maresa);

        return vlistStatut;
    }

    @Override
    public Reservation getById(int Id) {
        LOGGER.info("Methode getbyid de la reservation");

        //creation d'une requete avec pour resultat un parametre iD
        String vSQL = "SELECT * FROM public.reservation where id= ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());

        RowMapper<Reservation> maresa = new MapperReservation();

        Reservation reservation= vJdbcTemplate.queryForObject(vSQL,maresa,Id);

        return reservation;
    }

    @Override
    public Reservation annuleReservation(int Id) {
        LOGGER.info("Methode annulation de la reservation");
        String vSQL = "DELETE FROM public.reservation where id= ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());
        vJdbcTemplate.update(vSQL,Id);
        return null;
    }

    @Override
    public Reservation ajoutereservation(Reservation reservation) {
        LOGGER.info("Methode Creation d'une reservation ");
        String ajoutsql = "INSERT INTO public.reservation" +
                " (datereservationdebut,\n" +
                " datereservationfin,\n" +
                " utilisateurid,\n" +
                " topo_reservableid)" +
                "VALUES" +
                "(:dateReservationDebut,:dateReservationFin,:utilisateurid,:topoReservable)";


        SqlParameterSource ajoututil = new MapSqlParameterSource()
                .addValue("dateReservationDebut",reservation.getDateReservationDebut())
                .addValue("dateReservationFin",reservation.getDateReservationFin())
                .addValue("utilisateurid",reservation.getUtilisateur().getiD())
                .addValue("topoReservable",reservation.getTopoReservable().getiD());


        //Gestion de la clé primaire
        KeyHolder holder = new GeneratedKeyHolder();
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDatasource());
        vJdbcTemplate.update(ajoutsql, ajoututil, holder, new String[]{"id"});
        reservation.setiD(holder.getKey().intValue());
        return reservation;
    }

    @Override
    public void misajour(Reservation reservation) {
        LOGGER.info("Methode mise a jour de la reservation");

        String requetemaj = "UPDATE public.reservation SET " +
                "datereservationdebut = :dateReservationDebut, \n" +
                "datereservationfin = :dateReservationFin, \n" +
                "utilisateurid = :utilisateurid, \n" +
                "topo_reservableid = :topoReservable" +
                " WHERE id = :iD";




        SqlParameterSource vParams = new BeanPropertySqlParameterSource(reservation);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDatasource());
        int vNbrLigneMaJ = vJdbcTemplate.update(requetemaj, vParams);


    }

    @Override
    public Reservation find(Integer Id) {
        LOGGER.info("Methode find de la reservation");
        String vsql ="SELECT * FROM public.reservation WHERE id=?";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());
        Reservation reservation=(Reservation) vJdbcTemplate.queryForObject(vsql, new Object[] { Id }, new MapperReservation());
        if(reservation==null) {
            return null;
        }
        return reservation;
    }

    public List<Reservation> affichepardate(Date debut, Date fin, Integer toporeverableid){
        LOGGER.info("Methode de comparaison des dates de reservation");
        // String vsql ="SELECT * FROM public.reservation WHERE topo_reservableid = :toporeverableid AND ((datereservationdebut BETWEEN  :debut AND  :fin) OR (datereservationfin BETWEEN  :debut AND  :fin) OR (datereservationdebut <  :debut AND datereservationfin < :fin))";
        String vsql ="SELECT * FROM public.reservation WHERE topo_reservableid = ? AND ((datereservationdebut  BETWEEN ?  AND ?) Or (datereservationfin BETWEEN ? AND ?) OR (datereservationdebut <= ?  AND datereservationfin  > ?))";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());
        RowMapper<Reservation> maresa = new MapperReservation();


      //    List<Reservation> vliste= vJdbcTemplate.query(vsql, toporeverableid,debut,fin,debut,fin,debut,fin,maresa);
     List<Reservation> reservation= vJdbcTemplate.query(vsql,maresa,toporeverableid,debut,fin,debut,fin,debut,fin);


/**
        if(vliste==null) {
            System.out.println("topo disponible");
            return null;
        }
        return vliste;
*/
 return reservation;
    }

}
