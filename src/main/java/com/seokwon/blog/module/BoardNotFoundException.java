package com.seokwon.blog.module;

import org.springframework.http.HttpStatus;

/**
 * Created by ncl on 2017-06-09.
 */
public class BoardNotFoundException extends ResoueceNotFoundException{

    private final String boardname;

    public BoardNotFoundException(String boardname){
        this.boardname = boardname;
    }

    public String getBoardname(){
        return boardname;
    }

    @Override
    public String getError(){
        return "Board" + HttpStatus.NOT_FOUND.getReasonPhrase();
    }

    @Override
    public Object[] getArgs(){
        return new Object[]{boardname};
    }
}
