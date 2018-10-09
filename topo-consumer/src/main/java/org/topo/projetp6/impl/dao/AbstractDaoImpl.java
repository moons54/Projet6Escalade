package org.topo.projetp6.impl.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;





public abstract class AbstractDaoImpl {


    @Inject
    @Named("dataSourceP6")
    private DataSource datasource;



    public DataSource getDatasource() {

        return datasource;
    }


    @Inject
    @Named("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
