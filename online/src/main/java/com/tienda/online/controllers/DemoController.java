package com.tienda.online.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
//Recibir peticiones y devolver, esto ya es de springboot
public class DemoController {
    //Url para ese controler
    @GetMapping("test")    
    public String testApp(){
        return "String";
    }
}
