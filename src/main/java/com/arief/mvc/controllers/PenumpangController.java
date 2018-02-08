package com.arief.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/penumpang")
public class PenumpangController {

    @GetMapping("/form-penumpang")
    public String formPenumpangGET(){
        return "penumpang/form-penumpang";
    }

    @PostMapping("/form-penumpang")
    public String formPenumpangPOST(@RequestParam Map<String,String> requestParams, Model m){
        for(Map.Entry me : requestParams.entrySet()){
            System.out.println(me.getKey() + " : " + me.getValue());
        }
        return "redirect:";
    }


    @GetMapping("/list-penumpang")
    public String listPenumpang(){
        return "penumpang/list-penumpang";
    }

}
