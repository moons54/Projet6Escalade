package org.topo.projetp6.impl.dao;

import org.bean.topo.projetp6.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.topo.projetp6.impl.dao.mapper.MapperTopo;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {

    @Inject
    private TopoDao topoDao;

    @Override
    public List<Topo> affiche() {

        //requete SQL dans bd pour recupperer liste topo
        String vSQL = "SELECT * FROM public.topo";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());


        MapperTopo monmaptopo = new MapperTopo();


        List<Topo> vListStatut = vJdbcTemplate.query(vSQL, monmaptopo);

        return vListStatut;
    }

    @Override
    public Topo getbyiD(int Id) {


        //creation d'une requete avec pour resultat un parametre iD
        String vSQL = "SELECT * FROM public.topo where id= ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());


        Topo tops = (Topo) vJdbcTemplate.queryForObject(vSQL, (rs, rowNum) -> {
                    Topo lamtopo = new Topo();
                    lamtopo.setNom(rs.getString("nom"));
                    lamtopo.setDescriptiondestopo(rs.getString("description_topo"));
                    lamtopo.setHistoriquedestopo(rs.getString("historique_topo"));
                    lamtopo.setHauteurDuTopo(rs.getString("hauteur_global"));
                    lamtopo.setTypeDeroche(rs.getString("type_roche"));
                    lamtopo.setDescriptionDuRetour(rs.getString("description_du_retour"));
                    lamtopo.setNombreDevoie(rs.getInt("nombre_voie"));
                    lamtopo.setTypeDequipement(rs.getString("type_equipement"));




                    return lamtopo;
                }
                , Id
        );

return tops;
    }

    @Override
    public void miseajour(final Topo topo){
        String requetemaj="UPDATE public.topo SET " +
               "nom = :Nom, \n"+
               "description_topo = :descriptionDestopo, \n"+
                "historique_topo = :Historiquedestopo, \n" +
                "hauteur_global = :HauteurDuTopo, \n" +
                "type_roche  = :TypeDeroche, \n" +
                "nombre_voie = :NombreDevoie, \n" +
                "description_du_retour = :DescriptionDuRetour, \n" +
                "type_equipement = :TypeDequipement, \n" +
                "photo_topo = :photoDutopo"+
                " WHERE id = :id";

    SqlParameterSource vParams = new BeanPropertySqlParameterSource(topo);

    NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDatasource());
    int vNbrLigneMaJ = vJdbcTemplate.update(requetemaj, vParams);

}


    /**
     * creation d'un nouveau topo
     *
     * @param topo
     */

    @Override
    public Topo ajoutopo(final Topo topo) {

        String ajoutsql="INSERT INTO public.topo"+
                 "  nom_topo,\n"+
                " decription_topo,\n"+
                " historique_topo,\n"+
                " hauteur_global,\n"+
                " type_roche,\n"+
                " nombre_voie,\n"+
                " description_du_retour,\n"+
                " type_equipement,\n"+
                " photo_topo,\n"+
                "VALUES\n"+
                ":nomDutopo,:descriptionDutopo,:historiqueDutopo,:hauteurDutopo,:typeDeroche,:nombreDevoie,:descriptionDuretour," +
                ":typeDequipement,:photoDutopo";

        SqlParameterSource ajoutparam = new MapSqlParameterSource()
                .addValue("nomDutopo",topo.getNom())
                .addValue("descriptionDutopo",topo.getDescriptiondestopo())
                .addValue("historiqueDutopo",topo.getHistoriquedestopo())
                .addValue("hauteurDutopo",topo.getHauteurDuTopo())
                .addValue("typeDeroche",topo.getTypeDeroche())
                .addValue("nombreDevoie",topo.getNombreDevoie())
                .addValue("descriptionDuretour",topo.getDescriptionDuRetour())
                .addValue("typeDequipement",topo.getTypeDequipement())
                .addValue("photoDutopo",topo.getPhotoDuTopo());



        //Gestion de la clé primaire
        KeyHolder holder = new GeneratedKeyHolder();
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDatasource());
        topo.setiD(holder.getKey().intValue());
        return topo;

    }



}



