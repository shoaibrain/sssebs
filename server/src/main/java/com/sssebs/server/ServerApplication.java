package com.sssebs.server;

import com.sssebs.server.collection.Employee;
import com.sssebs.server.collection.Student;
import com.sssebs.server.repository.EmployeeRepository;
import com.sssebs.server.repository.ParentRepository;
import com.sssebs.server.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ServerApplication {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	ParentRepository parentRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}


}
