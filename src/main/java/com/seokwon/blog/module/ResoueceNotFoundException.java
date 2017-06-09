package com.seokwon.blog.module;

import org.springframework.http.HttpStatus;

/**
 * Created by ncl on 2017-06-09.
 */
public abstract class ResoueceNotFoundException extends RuntimeException{

    public HttpStatus getStatus(){
        return HttpStatus.NOT_FOUND;
    }

    public String getError(){
        return HttpStatus.NOT_FOUND.getReasonPhrase();
    }

    public String getCode(){
        return "error." + getClass().getSimpleName();
    }

    public Object[] getArgs(){
        return null;
    }
}
