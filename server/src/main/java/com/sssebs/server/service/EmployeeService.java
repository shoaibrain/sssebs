package com.sssebs.server.service;

import com.sssebs.server.model.Employee;
import com.sssebs.server.model.Parent;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAll();

    Optional<Employee> getEmployee(String employeeId);

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    Map<String, Object> getAllEmployeeInPage(Integer pageNum, Integer pageSize, String sortBy);

    List<Employee> getAllByExample(Employee employee);
}
