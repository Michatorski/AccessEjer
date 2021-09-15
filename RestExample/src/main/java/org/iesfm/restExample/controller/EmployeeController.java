package org.iesfm.restExample.controller;

import org.iesfm.restExample.Employee;
import org.iesfm.restExample.dao.DepartmentDAO;
import org.iesfm.restExample.dao.EmployeeDAO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class EmployeeController   {

    private DepartmentDAO departmentDAO;
    private EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/employees")
    public List <Employee> list(){
        return employeeDAO.list();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/departments/{departmentName}/employees")
    public List <Employee> list(@PathVariable("departmentName") String departmentName){

        if (departmentDAO.get(departmentName) == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ERROR 404, department not found"
            );
        }
        List<Employee> employees = employeeDAO.list(departmentName);
        return employees;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/employees/{nif}")
    public Employee getEmployee(@PathVariable("nif")String nif){
        Employee employee = employeeDAO.get(nif);
        if(employee == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ERROR 404, employee not found"
            );
        } else {
            return employee;
        }
    }

    @RequestMapping(method = RequestMethod.POST, path ="/employees")
    public void createEmployee (@RequestBody Employee newEmployee){

        boolean isCreated = employeeDAO.insert( newEmployee);

       if (newEmployee.getNif().equals(employeeDAO)){
           throw  new ResponseStatusException(
                   HttpStatus.CONFLICT, "ERROR 409, employee already exists"
           );
       }
    }

    @RequestMapping (method = RequestMethod.DELETE, path = "/employees/{nif}")
    public void deleteEmployee(@PathVariable("nif")String nif){
       boolean isDeleted = employeeDAO.delete(nif);
        if(!isDeleted){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ERROR 404, employee not found"
            );
        }
    }
}
