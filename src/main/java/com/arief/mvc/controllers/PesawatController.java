package com.arief.mvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/pesawat")
public class PesawatController {

    @GetMapping("/form-pesawat")
    public String formPesawatGET(){
        return "pesawat/form-pesawat";
    }

    @PostMapping("/form-pesawat")
    public String formPesawatPOST(@RequestParam Map<String ,String> requestParams){

        for(Map.Entry me : requestParams.entrySet()){
            System.out.println(me.getKey() + " : " + me.getValue());
        }

        return "redirect:";
    }

    @GetMapping("/list-pesawat")
    public String listPesawat(Model m){
        return "pesawat/list-pesawat";
    }
}
