package com.devsuperior.dscommerce.services.excepitions;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String msg){
        super(msg);
    }
}
