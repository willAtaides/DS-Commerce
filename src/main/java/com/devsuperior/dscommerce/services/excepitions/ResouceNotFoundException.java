package com.devsuperior.dscommerce.services.excepitions;

public class ResouceNotFoundException extends RuntimeException {

    public  ResouceNotFoundException(String msg){
        super(msg);
    }
}
