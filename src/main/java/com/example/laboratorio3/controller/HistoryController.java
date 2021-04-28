package com.example.laboratorio3.controller;


import com.example.laboratorio3.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//COMPLETAR
@Controller
@RequestMapping("/history")
public class HistoryController {
//COMPLETAR

    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping("")
    public String historyList(Model model){
        model.addAttribute("historyList",employeesRepository.findAll());
        return "history/list";
    }

    @PostMapping("/search")
    public String searchHistory(@RequestParam("searchParam") String searchParam,
                                Model model){
        model.addAttribute("historyLust",employeesRepository.historyEmpleadosFiltro(searchParam));
        return "/history";
    }

}
