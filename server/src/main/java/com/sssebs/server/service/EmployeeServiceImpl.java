package com.sssebs.server.service;

import com.sssebs.server.model.Employee;
import com.sssebs.server.repository.EmployeeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private static Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        try {
            employees = employeeRepository.findAll();
        } catch (Exception ex) {
            logger.warn("Failed to get employees", ex);
            ex.printStackTrace();
        }
        return employees;
    }

    @Override
    public Optional<Employee> getEmployee(String employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public void addEmployee(Employee employee) {
        try {
            employeeRepository.insert(employee);
            logger.info("New Employee added");
        } catch (Exception ex) {
            logger.warn("Failed to add Employee", ex);
            ex.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
            logger.info("Successfully updated Employee");
        } catch (Exception ex) {
            logger.warn("Failed tp update Employee", ex);
            ex.printStackTrace();
        }

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
