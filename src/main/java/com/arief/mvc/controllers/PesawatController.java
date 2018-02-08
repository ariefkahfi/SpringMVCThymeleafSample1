package com.arief.mvc.controllers;


import com.arief.mvc.dao.service.PesawatService;
import com.arief.mvc.models.Penumpang;
import com.arief.mvc.models.Pesawat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("/pesawat")
public class PesawatController {

    @Autowired
    private PesawatService pesawatService;

    @GetMapping("/form-pesawat")
    public String formPesawatGET(){
        return "pesawat/form-pesawat";
    }

    @PostMapping("/form-pesawat")
    public String formPesawatPOST(@RequestParam Map<String ,String> requestParams){
//        id_pesawat
//        nama_pesawat



        for(Map.Entry me : requestParams.entrySet()){
            System.out.println(me.getKey() + " : " + me.getValue());
        }

        Pesawat p = Pesawat.createPesawat(requestParams.get("id_pesawat"),requestParams.get("nama_pesawat"));
        pesawatService.save(p);

        return "redirect:";
    }

    @GetMapping("/list-pesawat")
    public String listPesawat(Model m){
        m.addAttribute("pesawatList",pesawatService.getAll());
        return "pesawat/list-pesawat";
    }
}
