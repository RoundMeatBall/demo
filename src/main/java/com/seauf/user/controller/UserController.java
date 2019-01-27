package com.seauf.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: Mr.lynn
 * @create: 2019-01-27 21:41
 **/
@Controller
@RequestMapping("/v1")
public class UserController {

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "hello";
    }
}
