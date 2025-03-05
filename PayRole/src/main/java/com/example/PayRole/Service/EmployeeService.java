package com.example.PayRole.Service;


import com.example.PayRole.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private List<Employee> employeeList = new ArrayList<>();
    private int ID_Counter = 1;


    //Get All the Employees
    public List<Employee> getAllEmployees(){
        return employeeList;
    }

    //get employee Based on the ID
    public Employee getEmployeeID(int ID){
        return employeeList.stream().filter(employee -> employee.getId() == ID).findFirst().orElse(null);
    }

    //Adding the Employees !!!
    public Employee addEmployee(Employee employee){
        employee.setId(ID_Counter++);
        employeeList.add(employee);
        return employee;
    }

    //Delete the Employee
    public boolean deleteEmployee(int id){
        return employeeList.removeIf(employee -> employee.getId() == id);
    }

    //Update the Employee Field
    public Employee updateEmployee(int id ,Employee employee){
        Optional<Employee> employeeExists = employeeList.stream().filter(employee1 -> employee.getId() == id).findFirst();

        if (employeeExists.isPresent()){
            Employee existingEmployee = employeeExists.get();
            existingEmployee.setName(employee.getName());
            existingEmployee.setSalary(employee.getSalary());
            return existingEmployee;
        }

        return null;
    }

}
