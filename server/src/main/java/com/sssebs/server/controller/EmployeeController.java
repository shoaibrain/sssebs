package com.sssebs.server.controller;

import com.sssebs.server.model.Employee;
import com.sssebs.server.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private static Logger logger = LogManager.getLogger(EmployeeController.class);
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/")
    public List<Employee> getAllEmployee(){
        return employeeService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, value="/")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

    @RequestMapping("/{employee_id}")
    public Optional<Employee> getEmployee(@PathVariable String employee_id) {
        return employeeService.getEmployee(employee_id);
    }

    @RequestMapping("/page")
    public Map<String, Object> getAllEmployeeInPage(
            @RequestParam(name="pageNum",defaultValue = "0") Integer pageNum,
            @RequestParam(name="pageSize", defaultValue = "2") Integer pageSize,
            @RequestParam(name="sortBy", defaultValue = "employee_id") String sortBy) {
        return employeeService.getAllEmployeeInPage(pageNum, pageSize, sortBy);
    }

    @RequestMapping("/example")
    public List<Employee> getAllParentByExample(@RequestBody Employee employee) {
        return employeeService.getAllByExample(employee);
    }

}
