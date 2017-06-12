package com.seokwon.blog.mapper;

import com.seokwon.blog.domain.UserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * Created by ncl on 2017-06-13.
 */
public interface LoginMapper {
    public UserVO findyByUserIdAndPassword(@Param("userId") String userId, @Param("Password") String Password);
}
