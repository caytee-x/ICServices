package com.ics.controller;

import com.ics.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HTTPController {



    @RequestMapping("/index")
    public String index(){
        return "index";
    }





}
