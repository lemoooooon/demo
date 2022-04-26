package org.example;

import org.example.dao.EmployeesRepository;
import org.example.model.Employees;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
    private final EmployeesRepository employeesRepository;

    public JpaApplication(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Optional<Employees> employeesOptional = employeesRepository.findById(10007);
        System.out.println(employeesOptional);
    }
}
