package com.CashRichUser.CashRichUser.Exception;

public class UserNameAlreadyPresentException extends RuntimeException{

    public UserNameAlreadyPresentException(String msg){
        super(msg);
    }
}
