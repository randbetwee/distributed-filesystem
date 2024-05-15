package com.distribute.service.exception;

public class FileNotFound extends ServiceException{
    public FileNotFound(){
        super();
    }

    public FileNotFound(String message){
        super(message);
    }

    public FileNotFound(String message, Throwable cause){
        super(message, cause);
    }

    public FileNotFound(Throwable cause){
        super(cause);
    }

    public FileNotFound(String message,Throwable cause,boolean enableSuppression ,boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
