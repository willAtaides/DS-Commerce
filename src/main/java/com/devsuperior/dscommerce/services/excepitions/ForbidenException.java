package com.devsuperior.dscommerce.services.excepitions;

public class ForbidenException extends RuntimeException {

    public ForbidenException(String msg){
        super(msg);
    }
}
