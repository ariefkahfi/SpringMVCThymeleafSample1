package com.arief.mvc.controllers;

import com.arief.mvc.dao.service.PenumpangService;
import com.arief.mvc.dao.service.PesawatService;
import com.arief.mvc.models.Penumpang;
import com.arief.mvc.models.Pesawat;
import com.arief.mvc.models.Tiket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/penumpang")
public class PenumpangController {


    @Autowired
    private PesawatService pesawatService;
    @Autowired
    private PenumpangService penumpangService;


    @ModelAttribute("pesawatList")
    public List<Pesawat> getAllPesawat(){
        return pesawatService.getAll();
    }


    @GetMapping("/form-penumpang")
    public String formPenumpangGET(){
        return "penumpang/form-penumpang";
    }

    @PostMapping("/form-penumpang")
    public String formPenumpangPOST(@RequestParam Map<String,String> requestParams, Model m){
        for(Map.Entry me : requestParams.entrySet()){
            System.out.println(me.getKey() + " : " + me.getValue());
        }

        Pesawat getOne = pesawatService.getOne(requestParams.get("pesawat_penumpang"));
        Tiket tiket = Tiket.createTiket(requestParams.get("asal"),requestParams.get("tujuan"));

        Penumpang p = Penumpang.createPenumpang(
                requestParams.get("nama_penumpang"),
                requestParams.get("jenkel_penumpang"),
                getOne,
                tiket
        );

        penumpangService.save(p);

        return "redirect:";
    }


    @GetMapping("/list-penumpang")
    public String listPenumpang(Model m){
        m.addAttribute("penumpangList",penumpangService.getAll());
        return "penumpang/list-penumpang";
    }

    @GetMapping("/delete/{idPenumpang}")
    public String deletePenumpang(@PathVariable("idPenumpang")int idP){
        Penumpang getOne = penumpangService.getOne(idP);
        penumpangService.delete(getOne);

        return "redirect:/penumpang/list-penumpang";
    }

}
