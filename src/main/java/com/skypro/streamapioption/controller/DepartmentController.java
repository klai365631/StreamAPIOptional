package com.skypro.streamapioption.controller;


import com.skypro.streamapioption.Service.DepartmentService;
import com.skypro.streamapioption.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeWithMaxSalaryFromDepartment(@RequestParam("departmentId") int department){
        return departmentService.findEmployeeWithMaxSalaryFromDepartment(department);
    }
    @GetMapping("/min-salary")
    public Employee findEmployeeWithMinSalaryFromDepartment(@RequestParam("departmentId") int department){
        return departmentService.findEmployeeWithMinSalaryFromDepartment(department);
    }
    @GetMapping(value = "/all",params = "departmentId")
    public List<Employee> findEmployeeFromDepartment(@RequestParam("departmentId") int department){
        return departmentService.findEmployeeFromDepartment(department);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> findEmployees(){
        return departmentService.findEmployees() ;
    }
}
