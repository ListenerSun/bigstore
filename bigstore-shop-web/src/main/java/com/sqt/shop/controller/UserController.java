//package com.sqt.shop.controller;
//
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
///**
// * @Description:
// * @author: sqt(男，未婚) 微信:810548252
// * @Date: Created in 2018-11-15  16:04
// */
//@Controller
//public class UserController {
//
//    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
//    @GetMapping("/user")
//    public String user(){
//        return "user";
//    }
//
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
//    @GetMapping("/admin")
//    public String admin(){
//        return "admin";
//    }
//}
