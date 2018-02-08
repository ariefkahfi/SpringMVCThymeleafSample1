package com.arief.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring4.view.ThymeleafView;

import java.util.Arrays;
import java.util.List;

@Controller
public class IndexController {



    @RequestMapping("/")
    public String indexPage(Model m){
        return "index";
    }
}
