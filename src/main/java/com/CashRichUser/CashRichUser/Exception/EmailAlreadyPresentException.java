package com.CashRichUser.CashRichUser.Exception;

public class EmailAlreadyPresentException extends RuntimeException{

    public EmailAlreadyPresentException(String msg){
        super(msg);
    }
}
