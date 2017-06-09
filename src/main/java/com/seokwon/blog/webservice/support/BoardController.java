package com.seokwon.blog.webservice.support;

import com.seokwon.blog.Board;
import com.seokwon.blog.Post;
import com.seokwon.blog.module.BoardService;
import com.seokwon.blog.module.PostForm;
import com.seokwon.blog.module.ResoueceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by ncl on 2017-06-09.
 */
@RestController
@RequestMapping("/board")
public class BoardController {
    private BoardService boardService;
    private MessageSourceAccessor messageSource;

    @Autowired
    public void setBoardService(BoardService boardService){
        this.boardService = boardService;
    }

    @RequestMapping(value = "/{boardname}/info", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ResponseEntity<Board> info(@PathVariable String boardname){
        return ResponseEntity.ok(boardService.findBoard(boardname));
    }

    @RequestMapping(value = "/{boardname}", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ResponseEntity<Board> free(@PathVariable String boardname){
        System.out.println(boardname);
        return ResponseEntity.ok(boardService.findBoard(boardname));
    }

    @RequestMapping(value = "/{boardname}/list", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ResponseEntity<List<Post>> listPosts(@PathVariable String boardname){
        return ResponseEntity.ok(boardService.findPosts(boardname));
    }

    @RequestMapping(value = "/{boardname}", method = {RequestMethod.POST})
    public ResponseEntity<Post> createPost(@PathVariable String boardname,@RequestBody @Valid PostForm postForm){
        return ResponseEntity.status(HttpStatus.CREATED).body(boardService.writePost(boardname, postForm));
    }

    @RequestMapping(value = "/{boardname}/{postId}", method = {RequestMethod.GET})
    public ResponseEntity<Post> view(@PathVariable Long postId){
        return ResponseEntity.ok(boardService.getPost(postId));
    }

    @RequestMapping(value = "/{boardname}/{postId}", method = {RequestMethod.PUT})
    public ResponseEntity<Post> update(@PathVariable Long postId, String author, String title, String content){
        return ResponseEntity.ok(boardService.editPost(postId, author, title, content));
    }

    @RequestMapping(value = "/{boardname}/{postId}", method = {RequestMethod.DELETE})
    public ResponseEntity<Post> deletePost(@PathVariable Long postId){
        return ResponseEntity.ok(boardService.erasePost(postId));
    }

    @ExceptionHandler(ResoueceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> resourceNotFoundException(ResourceNotFoundException exception, Locale locale){
        //System.out.print(exception.getMessage());
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
       // body.put("status", exception.getStatus());
        //body.put("error", exception.getError());
        //body.put("message", messageSource.getMessage(exception.getCode(), exception.getArgs(), locale).orElse("No message available"));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}
