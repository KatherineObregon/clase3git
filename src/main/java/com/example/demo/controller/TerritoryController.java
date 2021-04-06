package com.example.demo.controller;

import com.example.demo.entity.Shipper;
import com.example.demo.entity.Territorio;
import com.example.demo.repository.RegionRepository;
import com.example.demo.repository.TerritoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
public class TerritoryController {
    @Autowired
    TerritoryRepository territoryRepository;
    @Autowired
    RegionRepository regionRepository;
    @GetMapping ("/territory")
    public String territoryList(Model model){
        model.addAttribute("listaTerritorios", territoryRepository.findAll());
        return "territory/list";
    }
    @GetMapping ("/territory/new")
    public String territoryNew (Model model){
        model.addAttribute("listaTerritorios", territoryRepository.findAll());

        return "territory/newForm";
    }
    @PostMapping ("/territory/save")
    public  String territorySave(Territorio territorio){
        territoryRepository.save(territorio);
        return "redirect:/territory";
    }
    @GetMapping("/territory/edit")
    public String territoryedit(@RequestParam("id") String id, Model model){
        Optional<Territorio> territorioOpt = territoryRepository.findById(id);
        if(territorioOpt.isPresent()){
            Territorio territorio = territorioOpt.get();
            model.addAttribute("territorio", territorio);

            return "territory/editForm";
        }else{
            return "redirect:/territory";
        }
    }
    @RequestMapping ("/territory/delete")
    public String territoryDelete(@RequestParam("id") String id, Model model){
        Optional<Territorio> territorioOpt = territoryRepository.findById(id);
        if(territorioOpt.isPresent()){
            territoryRepository.deleteById(id);

            return "redirect:/territory";
        }else{
            return "redirect:/territory";
        }
    }

}
