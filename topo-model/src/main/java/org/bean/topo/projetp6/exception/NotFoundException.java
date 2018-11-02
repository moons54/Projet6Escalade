package org.bean.topo.projetp6.exception;

public class NotFoundException extends Exception{

    public NotFoundException() {
    }

    public NotFoundException(String avertissement) {
        super(avertissement);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
