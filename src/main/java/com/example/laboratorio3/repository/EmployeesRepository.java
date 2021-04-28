package com.example.laboratorio3.repository;


import com.example.laboratorio3.entity.Employees;
import dto.DepartamentosPaisCiudadDTO;
import dto.EmpleadosSalarioDTO;
import dto.GerenteConExperienciaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {

@Query(value = "SELECT e.first_name as 'nombre', e.last_name as 'apellido', jh.start_date as 'fechainicio',\n" +
        "jh.end_date as 'fechafin',j.job_title as 'puesto' FROM hr.employees e\n" +
        "inner join hr.job_history jh on(e.employee_id=jh.employee_id)\n" +
        "inner join hr.jobs j on (j.job_id=jh.job_id)\n" +
        "where salary>15000",nativeQuery = true)
List<EmpleadosSalarioDTO> obtenerEmpleadosPorSalario();


@Query(value = "SELECT c.country_name, l.city, count(e.employee_id) AS `empleados`, \n" +
        "count(distinct l.city) as 'cantidad' FROM countries c\n" +
        "INNER JOIN locations l ON (l.country_id = c.country_id)\n" +
        "INNER JOIN departments d ON (d.location_id = l.location_id)\n" +
        "INNER JOIN employees e ON (e.department_id = d.department_id)\n" +
        "GROUP BY l.city\n" +
        "HAVING `empleados` > 3",nativeQuery = true)
    List<DepartamentosPaisCiudadDTO> obtenerReporteDepartamentosPaisCiudad();

@Query(value = "SELECT d.department_name as 'departamento', m.first_name as 'nombre',m.last_name as 'apellido',\n" +
        "\t m.salary as 'sueldo' FROM employees e \n" +
        "INNER JOIN jobs j ON e.job_id=j.job_id \n" +
        "LEFT JOIN departments d ON e.department_id=d.department_id \n" +
        "LEFT JOIN employees m ON e.manager_id= m.employee_id\n" +
        "where (now()-m.hire_date)>5",nativeQuery = true)
    List<GerenteConExperienciaDTO> obtenerGerenteConExperiencia();

    @Query(value="select e.first_name,e.last_name,j.job_title,d.department_name,l.city  from employees e\n" +
            "inner join jobs j on (j.job_id= e.job_id)\n" +
            "inner join departments d on (d.department_id = e.department_id)\n" +
            "inner join locations l on (d.location_id = l.location_id)\n" +
            "where first_name like ?1 or last_name like ?1 \n" +
            "or job_title like ?1 or department_name like ?1 ;", nativeQuery = true)
    List<Employees> buscarEmpleadosporBuscador(String nombre);




}
