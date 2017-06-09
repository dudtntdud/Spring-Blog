package com.seokwon.blog;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ncl on 2017-06-09.
 */

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String title;
    private String content;
    private Date createAt;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Board board;

    protected Post() {   }

    protected Post(Board board, String author, String title, String content){
        this.author = author;
        this.title = title;
        this.content = content;
        this.createAt = new Date();

        this.board = board;
    }

    public Post update(String author, String title, String content){
        this.author = author;
        this.title = title;
        this.content = content;

        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
