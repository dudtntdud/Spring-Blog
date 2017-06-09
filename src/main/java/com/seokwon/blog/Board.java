package com.seokwon.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by ncl on 2017-06-09.
 */

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date createdAt;

    protected Board() {}

    public Board(String name){
        this.name = name;
        this.createdAt = new Date();
    }

    public Post write(String author, String title, String content){
        return new Post(this, author, title, content);
    }

    public String getName(){
        return name;
    }

    public Date getCreateAt(){
        return createdAt;
    }
}
