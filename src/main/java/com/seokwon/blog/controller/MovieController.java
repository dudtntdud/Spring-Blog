package com.seokwon.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by ncl on 2017-06-14.
 */
@Controller
public class MovieController {

    @RequestMapping("/moviesearch")
    public ModelAndView index()
    {
        return new ModelAndView("moviesearch");
    }
}
