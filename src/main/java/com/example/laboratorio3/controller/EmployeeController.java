package com.example.laboratorio3.controller;

import com.example.laboratorio3.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//COMPLETAR
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    //COMPLETAR
    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping(value = {"", "/"})
    public String listaEmployee(Model model){
        //COMPLETAR
        model.addAttribute("listaEmpleados", employeesRepository.findAll());
        return "employee/lista";
    }

    public String nuevoEmployeeForm( ) {
        //COMPLETAR
        return "0";
    }


    public String guardarEmployee() {
        //COMPLETAR
        return "0";
    }


    public String editarEmployee() {
        //COMPLETAR
        return "0";
    }


    public String borrarEmpleado() {

       //COMPLETAR
        return "0";
    }

    //COMPLETAR

}
