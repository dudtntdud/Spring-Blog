package com.seokwon.blog.mapper;

import com.seokwon.blog.domain.ReplyVO;
import org.apache.ibatis.annotations.Param;
import com.seokwon.blog.domain.BoardVO;

import java.util.List;

/**
 * Created by ncl on 2017-06-11.
 */
public interface BoardMapper {
    //글작성
    public void boardInsert(BoardVO board)throws Exception;

    //글목록
    public List<BoardVO> boardList()throws Exception;

    //글보기
    public BoardVO boardView(int bno)throws Exception;

    //조회수 증가
    public void hitPlus(int bno)throws Exception;

    //추천수 증가
    public void recommandPlus(int bno)throws Exception;

    //글수정
    public void boardUpdate(BoardVO vo)throws Exception;

    //글삭제
    public void boardDelete(int bno)throws Exception;

    //댓글목록
    public List<ReplyVO> replyList()throws Exception;

    //리플작성
    public void replyInsert(ReplyVO board)throws Exception;

    //리플보기
    public BoardVO replyView(int bno)throws Exception;

    //리플수정
    public void replyUpdate(ReplyVO vo)throws Exception;

    //리플삭제
    public void replyDelete(int bno)throws Exception;
}
