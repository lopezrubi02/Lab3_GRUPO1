package com.example.laboratorio3.controller;

import com.example.laboratorio3.repository.EmployeesRepository;
import dto.DepartamentosPaisCiudadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping(value = {"","/"})
    public String indice(){
        return "Search/indice";
    }


    @GetMapping(value = {"/salario"})
    public String cantidadEmpleadosPorSalario(Model model) {

        model.addAttribute("listaEmpleadosPorSalario", employeesRepository.obtenerEmpleadosPorSalario());
        model.addAttribute("listaDepartamentoPaisCiudad",employeesRepository.obtenerReporteDepartamentosPaisCiudad());

        return "Search/indice";
    }


}
