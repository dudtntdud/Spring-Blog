package com.seokwon.blog.module;

import com.seokwon.blog.Board;
import com.seokwon.blog.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ncl on 2017-06-09.
 */
public interface PostRepository extends JpaRepository<Post, Long>{
    List<Post> findByBoard(Board board);
}
