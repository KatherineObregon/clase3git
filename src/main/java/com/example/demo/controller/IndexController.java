package com.example.demo.controller;

import com.example.demo.entity.Alumno;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class IndexController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homePage(Model model){

        Alumno alumno = new Alumno("Juan", "1111");
        model.addAttribute("alumno", alumno);
        model.addAttribute("listaAlumnos", listaAlumnos());
        return "homePage";
    }

    @PostMapping("/formPrueba")
    public String formPrueba(@RequestParam("codigo") String codigo, Model model){
        model.addAttribute("codigo", codigo);
        return "vista2";
    }

    public ArrayList<Alumno> listaAlumnos(){
        ArrayList<Alumno> lista = new ArrayList<>();
        lista.add(new Alumno("Juan","33333"));
        lista.add(new Alumno("Pedro", "22222"));
        lista.add(new Alumno("Raul", "123444"));
        lista.add(new Alumno( "Boni", "999999"));
        return lista;
    }
}
