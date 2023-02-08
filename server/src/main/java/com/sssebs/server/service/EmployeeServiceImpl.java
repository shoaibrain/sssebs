package com.sssebs.server.service;

import com.sssebs.server.model.Employee;
import com.sssebs.server.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployee(String employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.insert(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Map<String, Object> getAllEmployeeInPage(Integer pageNum, Integer pageSize, String sortBy) {
        Map<String, Object> response = new HashMap<>();
        Sort sort = Sort.by(sortBy);
        Pageable page = PageRequest.of(pageNum,pageSize,sort);
        Page<Employee> employeePage = employeeRepository.findAll(page);
        response.put("data", employeePage.getContent());
        response.put("Total Page",employeePage.getTotalPages());
        response.put("Total Elements", employeePage.getTotalElements());
        response.put("Current Page", employeePage.getNumber());
        return response;
    }

    @Override
    public List<Employee> getAllByExample(Employee employee) {
        Example<Employee> e = Example.of(employee);
        return employeeRepository.findAll(e);
    }
}
