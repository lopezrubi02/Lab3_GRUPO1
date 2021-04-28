package com.example.laboratorio3.controller;

import com.example.laboratorio3.entity.Employees;
import com.example.laboratorio3.repository.DepartmentsRepository;
import com.example.laboratorio3.repository.EmployeesRepository;
import com.example.laboratorio3.repository.JobsRepository;
import com.example.laboratorio3.repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

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

    @Autowired
    LocationsRepository locationsRepository;

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

    @PostMapping("/save")
    public String guardarEmployee(Employees employees,RedirectAttributes attr) {
        if (employees.getEmployeeId() == 0) {
            attr.addFlashAttribute("msg", "Usuario creado exitosamente");
        } else {
            attr.addFlashAttribute("msg", "Usuario actualizado exitosamente");
        }
        employeesRepository.save(employees);
        //COMPLETAR
        return "redirect:/employee";
    }

    @GetMapping(value = { "/edit"})
    public String editarEmployee(Model model, @RequestParam("id") int id) {
        Optional<Employees> optionalEmployees = employeesRepository.findById(id);

        if(optionalEmployees.isPresent()){
            model.addAttribute("employees",optionalEmployees.get());
            model.addAttribute("listaJefes",getListaJefes());
            model.addAttribute("listaDepartamentos", departmentsRepository.findAll());
            model.addAttribute("listaTrabajos",jobsRepository.findAll());
            return "employee/editFrm";
        }else{
            return "redirect:/employee";
        }
        //COMPLETAR
    }

    @GetMapping(value = { "/delete"})
    public String borrarEmpleado(@RequestParam("id") int id, RedirectAttributes attr) {
        Optional<Employees> optionalEmployees =employeesRepository.findById(id);
        if(optionalEmployees.isPresent()){
            employeesRepository.deleteById(id);
            attr.addFlashAttribute("msg","Usuario borrado exitosamente");
        }
       //COMPLETADO
        return "redirect:/employee";
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
    @PostMapping("/BuscarEmpleados")
    public String buscarEmpleado(@RequestParam("searchField") String searchField, Model model){
        List<Employees> listaEmpleados = employeesRepository.buscarEmpleadosporBuscador(searchField);
        model.addAttribute("listaEmpleados",listaEmpleados);
        return "employee/lista";
    }

}
