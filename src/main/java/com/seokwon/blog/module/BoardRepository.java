package com.seokwon.blog.module;

import com.seokwon.blog.Board;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ncl on 2017-06-09.
 */
public interface BoardRepository extends JpaRepository<Board, Long>{
    Board findByName(String name);
}
