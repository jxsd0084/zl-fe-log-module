package com.zhisland.fe.log.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by taoli on 17/6/8.
 */
@Controller
public class IndexController extends BaseController {

    @RequestMapping("index")
    public ModelAndView showIndex(){
        return new ModelAndView("index");
    }
    
}
