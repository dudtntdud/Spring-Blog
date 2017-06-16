package com.seokwon.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by ncl on 2017-06-16.
 */
@Controller
public class ExceptionController {
    @RequestMapping("/notAllowedUser")
    public ModelAndView loginProcess(Model model, HttpSession session)
    {
        ModelAndView mv = new ModelAndView();
        session.invalidate();
        mv.setViewName("redirect:/notAllowedUser");
        return mv;
    }
}
