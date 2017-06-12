package com.seokwon.blog.domain;

import java.util.Date;

/**
 * Created by ncl on 2017-06-12.
 */
public class ReplyVO {
    private int bno;
    private int board_bno;
    private String content;
    private String writer;
    private Date reg_date;

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public int getBoard_bno() {
        return board_bno;
    }

    public void setBoard_bno(int board_bno) {
        this.board_bno = board_bno;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

}
