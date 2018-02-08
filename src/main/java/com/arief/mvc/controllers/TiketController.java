package com.arief.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tiket")
public class TiketController {


    @GetMapping("/list-tiket")
    public String listTiket(Model m){
        return "tiket/list-ticket";
    }
}
