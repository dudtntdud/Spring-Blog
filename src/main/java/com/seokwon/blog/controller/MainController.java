package com.seokwon.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ncl on 2017-06-16.
 */
@Controller
public class MainController {
    @RequestMapping("/")
    public String index()
    {
        return "redirect:/board";
    }
}
