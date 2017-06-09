package com.seokwon.blog.webservice.support;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ncl on 2017-06-09.
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String indexview(){
        return "index";
    }
}
