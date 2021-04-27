package com.example.laboratorio3.controller;

import com.example.laboratorio3.entity.Employees;
import com.example.laboratorio3.repository.DepartmentsRepository;
import com.example.laboratorio3.repository.EmployeesRepository;
import com.example.laboratorio3.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//COMPLETAR
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    //COMPLETAR
    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    JobsRepository jobsRepository;

    @Autowired
    DepartmentsRepository departmentsRepository;

    @GetMapping(value = {"", "/"})
    public String listaEmployee(Model model){
        //COMPLETAR
        model.addAttribute("listaEmpleados", employeesRepository.findAll());
        return "employee/lista";
    }

    @GetMapping(value = { "/new"})
    public String nuevoEmployeeForm(Model model) {
        model.addAttribute("listaTrabajos",jobsRepository.findAll());
        model.addAttribute("listaJefes",getListaJefes());
        model.addAttribute("listaDepartamentos",departmentsRepository.findAll());
        return "employee/newFrm";
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

    public List<Employees> getListaJefes() {
        List<Employees> listaJefes = employeesRepository.findAll();
        Employees e = new Employees();
        e.setEmployeeId(0);
        e.setFirstName("--No tiene Jefe--");
        listaJefes.add(0, e);
        return listaJefes;
    }

    //COMPLETAR

}
