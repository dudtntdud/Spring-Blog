package com.seokwon.blog.Interceptor;

import com.seokwon.blog.domain.BoardVO;
import com.seokwon.blog.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ncl on 2017-06-15.
 */

@Component
public class CertificationInterceptor extends HandlerInterceptorAdapter{

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {
            Object id = request.getSession().getAttribute("id");
            String direct = request.getServletPath();
            int postnumber = Integer.parseInt(direct.replaceAll("[^0-9]", ""));
            String id2= (String) request.getSession().getAttribute("id");

            BoardVO board = boardMapper.findIdByPostNumber(postnumber);
            /* 로그인계정이 수정,삭제를 시도하는 계정과 같음?*/
            if( (id == null) || !(id2.equals(board.getWriter()))){

                response.sendRedirect("/notAllowedUser");
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
