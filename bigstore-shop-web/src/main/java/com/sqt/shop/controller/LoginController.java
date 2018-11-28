package com.sqt.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-14  18:04
 */
@Controller()
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "forward: /admin/index.html";
    }
}
