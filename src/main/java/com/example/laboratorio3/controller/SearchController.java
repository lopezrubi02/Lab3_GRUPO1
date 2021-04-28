package com.example.laboratorio3.controller;

import com.example.laboratorio3.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {

    @Autowired
    EmployeesRepository employeesRepository;


    @GetMapping(value = {"/salario"})
    public String cantidadEmpleadosPorSalario(Model model) {

        model.addAttribute("listaEmpleadosPorSalario", employeesRepository.obtenerEmpleadosPorSalario());
        model.addAttribute("listaDepartamentoPaisCiudad",employeesRepository.obtenerReporteDepartamentosPaisCiudad());
        model.addAttribute("listaGerentesExperiencia",employeesRepository.obtenerGerenteConExperiencia());
        return "search/indice";
    }


}
