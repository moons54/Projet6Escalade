package org.topo.projetp6.impl.dao;


import org.bean.topo.projetp6.Site;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.topo.projetp6.impl.dao.mapper.MapperSite;

@Named
public class SiteDaoimpl extends AbstractDaoImpl implements SiteDao  {

    @Inject
    SiteDao siteDao;

    @Override
    public List<Site> affiche(int idtopo) {
        //requete SQL dans bd pour recupperer liste des sites
       String vSQL = "SELECT * FROM public.site where topoid= ?";
       // String vSQL = "SELECT * FROM public.site ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());

        MapperSite monmapsite = new MapperSite();
        
        
        List<Site> vlistesite = vJdbcTemplate.query(vSQL, monmapsite,idtopo);
        
        return vlistesite;
    }

    @Override
    public void miseajour(Site site) {

    }

    @Override
    public Site ajoutopo(Site site) {
        return null;
    }

    @Override
    public Site getbyiD(int Id) {
        //creation d'une requete avec pour resultat un parametre iD
        String vSQL = "SELECT * FROM public.site where id= ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());


        Site site = (Site) vJdbcTemplate.queryForObject(vSQL, (rs, rowNum) -> {
                    Site gsite = new Site();
                    gsite.setiD(rs.getInt("id"));


                    gsite.setNom(rs.getString("nom"));
                    gsite.setCoordonneesGps(rs.getString("coordonnees_gps"));
                    gsite.setIdentifiant(rs.getInt("identifiant"));




                    return gsite;
                }
                , Id
        );

        return site;
    }

    @Override
    public Site recherche(int Id ){
        String vsql ="SELECT * FROM public.site WHERE id= ?";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());

        Site site = vJdbcTemplate.queryForObject(vsql, new Object[]{Id}, new MapperSite());
        return site;

    }



    @Override
    public Site supprimetopo(int Id) {
        return null;
    }
}
