package org.topo.projetp6.manager;


import org.springframework.transaction.PlatformTransactionManager;
import org.topo.projetp6.impl.DaoFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


public abstract class AbstractManager {


    @Inject
    private DaoFactory daoFactory;

    @Inject
    @Named("TXtransactionTOPO")
    private PlatformTransactionManager platformTransactionManager;

    public PlatformTransactionManager getPlatformTransactionManager() {
        return platformTransactionManager;
    }

    public DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }


    public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
        this.platformTransactionManager = platformTransactionManager;
    }

    protected Validator getConstraintValidator() {
        ValidatorFactory vFactory = Validation.buildDefaultValidatorFactory();
        Validator vValidator = vFactory.getValidator();
        return vValidator;
    }

}
