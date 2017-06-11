package com.seokwon.blog.mapper;

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

    //글수정
    public void boardUpdate(BoardVO vo)throws Exception;

    //글삭제
    public void boardDelete(int bno)throws Exception;
}
