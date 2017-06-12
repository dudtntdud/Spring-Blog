package com.seokwon.blog.controller;

import com.seokwon.blog.domain.BoardVO;
import com.seokwon.blog.domain.ReplyVO;
import com.seokwon.blog.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by ncl on 2017-06-12.
 */

@Controller
@RequestMapping("/board")
public class BoardListController {
    @Autowired
    private BoardMapper boardMapper;


    //게시글,댓글 목록
    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView list(Model model, @RequestParam(value ="board", defaultValue = "board") String board) throws Exception{
        model.addAttribute("board", "ok");
        List<BoardVO> list = boardMapper.boardList();

        return new ModelAndView("boardList","list",list);
    }

    //게시글 작성 페이지(GET)
    @RequestMapping(value="/post",method=RequestMethod.GET)
    public ModelAndView writeForm() throws Exception{

        return new ModelAndView("boardWrite");
    }

    //게시글 작성(POST)
    @RequestMapping(value="/post",method=RequestMethod.POST)
    public String write(Model model, @ModelAttribute("BoardVO") BoardVO board) throws Exception{

        boardMapper.boardInsert(board);

        return "redirect://localhost:8080/board";
    }

    @RequestMapping(value="/{bno}",method=RequestMethod.GET)
    public ModelAndView view(Model model, @RequestParam(value ="reply", defaultValue = "reply") String reply, @PathVariable("bno") int bno) throws Exception{

        BoardVO board = boardMapper.boardView(bno);
        boardMapper.hitPlus(bno);

        model.addAttribute("reply", "ok");
        List<ReplyVO> reply_list = boardMapper.replyList();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("boardView");
        mav.addObject("board",board);
        mav.addObject("reply_list",reply_list);

//        new ModelAndView("boardView","board",board);
//        return new ModelAndView("boardView","reply_list",reply_list);
        return mav;
    }

    @RequestMapping(value="/{bno}/recommand",method=RequestMethod.GET)
    public String recommand(@PathVariable("bno") int bno) throws Exception{

        BoardVO board = boardMapper.boardView(bno);
        boardMapper.recommandPlus(bno);

        return "redirect://localhost:8080/board/" + bno;
    }

    //게시글 수정 페이지(GET)
    @RequestMapping(value="/post/{bno}", method=RequestMethod.GET)
    public ModelAndView updateForm(@PathVariable("bno") int bno) throws Exception{

        BoardVO board = boardMapper.boardView(bno);

        return new ModelAndView("boardUpdate","board",board);
    }

    //게시글 수정(PATCH)
    @RequestMapping(value="/post/{bno}", method=RequestMethod.PATCH)
    public String update(@ModelAttribute("BoardVO")BoardVO board,@PathVariable("bno") int bno) throws Exception{

        boardMapper.boardUpdate(board);

        return "redirect://localhost:8080/board/"+bno;
    }
    //게시글 삭제(DELETE)
    @RequestMapping(value="/post/{bno}", method=RequestMethod.DELETE)
    public String delete(@PathVariable("bno") int bno) throws Exception{

        boardMapper.boardDelete(bno);

        return "redirect://localhost:8080/board";
    }

    //리플 작성(POST)
    @RequestMapping(value="/reply/{board_bno}",method=RequestMethod.POST)
    public String reply_write(Model model, @ModelAttribute("ReplyVO") ReplyVO reply, @PathVariable("board_bno") int board_bno) throws Exception{

        boardMapper.replyInsert(reply);

        return "redirect://localhost:8080/board/"+board_bno;
    }
}
