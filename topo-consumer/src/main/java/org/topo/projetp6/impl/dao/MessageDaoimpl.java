package org.topo.projetp6.impl.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bean.topo.projetp6.Message;
import org.bean.topo.projetp6.Topo;
import org.bean.topo.projetp6.Utilisateur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.topo.projetp6.impl.dao.mapper.MapperMessage;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Types;
import java.util.List;

@Named
public class MessageDaoimpl extends AbstractDaoImpl implements MessageDao{

    @Inject
    private TopoDao topoDao;

    @Inject
    private UtilisateurDao utilisateurDao;

    @Inject
    MapperMessage mapperMessage;

    private static final Logger LOGGER=(Logger) LogManager.getLogger(MessageDaoimpl.class);

    @Override
    public List<Message> affichemessage() {
        LOGGER.info("Methode Liste des commentaires");

        //requete SQL dans bd pour recupperer liste messages
        String vSQL = "SELECT * FROM public.message";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());

        List<Message> vListeStatut =vJdbcTemplate.query(vSQL,mapperMessage);

        return vListeStatut;
    }

    @Override
    public Message getbyId(int Id) {
        LOGGER.info("Methode getById du commentaire");

        String vSQL = "SELECT * FROM public.message where id= ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());

        Message message=vJdbcTemplate.queryForObject(vSQL,mapperMessage,Id);
        return message;
    }

    @Override
    public Message supprimemessage(int Id) {
        LOGGER.info("Methode suppression d'un message");
        String vSQL = "DELETE FROM public.message where id= ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());

        vJdbcTemplate.update(vSQL,Id);
        return null;
    }

    @Override
    public Message ajoutemessage(final Message message) {
        LOGGER.info("Methode Creation d'un commentaire");
     String ajoutsql = "INSERT INTO public.message" +
                " (reference,\n " +
                " commentaire,\n " +
                " topoid,\n " +
                " note,\n " +
                " utilisateurid,\n " +
                " date_message)" +
                "VALUES" +
                "(:reference,:commentaire,:topoid,:note,:utilisateurid,NOW())";



        //Gestion de la clé primaire
        KeyHolder holder = new GeneratedKeyHolder();
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDatasource());

        MapSqlParameterSource ajoutparam = new MapSqlParameterSource()
                .addValue("reference",message.getReference())
                .addValue("commentaire",message.getCommentaire())
                .addValue("topoid",message.getTopo().getiD())
                .addValue("note",message.getNote())
                .addValue("utilisateurid",message.getUtilisateur().getiD());
             //   .addValue("date_message",message.getMessageDate());


        vJdbcTemplate.update(ajoutsql, ajoutparam, holder, new String[]{"id"});
        message.setiD(holder.getKey().intValue());


      /**
        String vsql ="INSERT INTO public.message (reference,commentaire,date_ecriture,utilisateurid,topoid,note) VALUES(?,?,?,?,?,?)";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());
        vJdbcTemplate.update(vsql, message.getReference(),message.getCommentaire(),message.getDateEcriture(),message.getUtilisateur().getiD(),message.getTopo().getiD(),message.getNote());
*/
        return message;
    }

    @Override
    public void modifiemessage(final Message message) {
        LOGGER.info("Methode Modification des commentaires");

        String requetemaj = "UPDATE public.message SET " +
                "reference = :reference, \n" +
                "commentaire = :commentaire, \n" +
            //    "utilisateurid = :utilisateurid, \n" +
             //   "topoid  = :topoid, \n" +
                "note = :note" +
                " WHERE id = :iD";

        SqlParameterSource vparams = new BeanPropertySqlParameterSource(message);


        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDatasource());
        int vNbrLigneMaJ = vJdbcTemplate.update(requetemaj, vparams);



    }

    @Override
    public List<Message> affichemessagebyTopo(int topoid) {
        LOGGER.info("Methode Liste des commentaires par topo");

        //requete SQL dans bd pour recupperer liste messages
        String vSQL = "SELECT * FROM public.message where topoid=?";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());

        List<Message> vListeStatut =vJdbcTemplate.query(vSQL,mapperMessage,topoid);

        return vListeStatut;
    }
}
