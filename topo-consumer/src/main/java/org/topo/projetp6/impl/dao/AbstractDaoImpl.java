package org.topo.projetp6.impl.dao;


import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;





public abstract class AbstractDaoImpl {


    @Inject
    @Named("dataSourceP6")
    private DataSource datasource;



     DataSource getDatasource() {

        return datasource;
    }




}
