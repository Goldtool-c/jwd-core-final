package com.epam.jwd.core_final.exception;

public class InvalidStateException extends Exception {
    private final String entityName;
    private final Object[] args;
    public InvalidStateException (String entityName) {
        super();
        this.entityName = entityName;
        this.args = null;
    }
}
