package com.example.demo.controller;


import com.example.demo.entity.Carro;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/carro")
public class CarroController {
    @GetMapping("/form")
    public String formCarro(){
        return  "formCarro";
    }
    /*@RequestParam("placa") String placa,
    @RequestParam("color") String color,
    @RequestParam("marca") String marca,
    @RequestParam("anioFabricacion") Integer anioFabricacion
    @PostMapping("/guardar")

    Se puede reemplaar por lo siguiente si los atributos se llaman igual que los name del form

    */
    @PostMapping("/guardar")
    public String guardarCarro(Carro carro){

        System.out.println("placa: "+carro.getPlaca());
        System.out.println("color: "+carro.getColor());
        System.out.println("marca: "+carro.getMarca());
        System.out.println("anioFabricacion: "+carro.getAnioFabricacion());
        return "redirect:/";
    }
}
