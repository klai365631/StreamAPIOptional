package com.skypro.streamapioption.Service;


import com.skypro.streamapioption.exeption.EmployeeAlreadyAddedException;
import com.skypro.streamapioption.exeption.EmployeeNotFoundException;
import com.skypro.streamapioption.exeption.EmployeeStorageIsFullException;
import com.skypro.streamapioption.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class EmployeeService {

    private static final int SIZE=10;
    private final Map<String, Employee> employees = new HashMap<>();



    private String getKey(String name, String surname){
        return name + "|" + surname;}

    public Employee addEmployee(String name,
                                String surname,
                                int department,
                                double salary) {
        Employee employee = new Employee(name,surname,department,salary);

        String key = getKey(name,surname);
        if (employees.containsKey(key)){
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size()<SIZE){
            employees.put(key,employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();


    }
    public Employee removeEmployee(String name, String surname) {
        String key = getKey(name, surname);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }

        return employees.remove(key);

    }
    public Employee findEmployee(String name, String surname) {
        String key = getKey(name, surname);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(key);


    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }



}
