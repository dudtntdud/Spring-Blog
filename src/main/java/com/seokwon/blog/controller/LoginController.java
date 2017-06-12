package com.seokwon.blog.controller;

import javax.servlet.http.HttpSession;

import com.seokwon.blog.domain.UserVO;
import com.seokwon.blog.mapper.LoginMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by ncl on 2017-06-13.
 */
@Controller
public class LoginController {
    @Autowired
    private LoginMapper loginMapper;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public String login(Model model, HttpSession session)
    {
        String id = session.getAttribute("id") == null ? (String) session.getAttribute("id") : "";
        model.addAttribute("id", id);
        return "login";
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST )
    public ModelAndView loginProcess(@RequestParam("userId") String id,
                                     @RequestParam("Password") String password,
                                     Model model, HttpSession session)
    {
        ModelAndView mv = new ModelAndView();

        UserVO loginUser = loginMapper.findyByUserIdAndPassword(id, password);

        if(loginUser != null){
            session.setAttribute("id", id);
            mv.setViewName("redirect:/board");
            return mv;
        }

        mv.setViewName("redirect:/login");
        return mv;

    }

    @RequestMapping("/logout")
    public ModelAndView loginProcess(Model model, HttpSession session)
    {
        ModelAndView mv = new ModelAndView();
        session.invalidate();
        mv.setViewName("redirect:/login");
        return mv;
    }
}
