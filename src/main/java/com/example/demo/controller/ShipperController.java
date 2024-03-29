package com.example.demo.controller;

import com.example.demo.entity.Shipper;
import com.example.demo.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller

public class ShipperController {
    @Autowired
    ShipperRepository shipperRepository ;



    @GetMapping("/shipper")
    public String shipperList(Model model){

        model.addAttribute("shipperList", shipperRepository.findAll());
        return "shipper/list";
    }
    @GetMapping("/shipper/new")
    public  String shipperNew(){
        return "shipper/newForm";
    }


    @PostMapping ("/shipper/save")
    public  String shipperSave (Shipper shipper, RedirectAttributes attr){
        shipperRepository.save(shipper);
        attr.addFlashAttribute("msg", "Usuario creado exitosamente");
        return "redirect:/shipper";
    }
    @GetMapping("/shipper/edit")
    public  String editShipper(@RequestParam("id") int id, Model model){
        Optional<Shipper> shipperOpt = shipperRepository.findById(id);
        if(shipperOpt.isPresent()){
            Shipper shipper = shipperOpt.get();
            model.addAttribute("shipper", shipper);
            return "shipper/editForm";
        }else{
            return "redirect:/shipper";
        }
    }

    @GetMapping ("/shipper/delete")
    public  String deleteShipper(@RequestParam("id") int id){
        Optional<Shipper> shipperOpt = shipperRepository.findById(id);
        if(shipperOpt.isPresent()){
            shipperRepository.deleteById(id);

            return "redirect:/shipper";
        }
        return "redirect:/shipper";
    }

    @PostMapping ("/shipper/search")
    public String searchShipper(@RequestParam("searchName") String searchName, Model model){

        model.addAttribute("shipperList", shipperRepository.findByCompanyname(searchName));
        model.addAttribute("shipperList", shipperRepository.listarTransportistasPorNombre(searchName));
        return "shipper/list";

    }
}
