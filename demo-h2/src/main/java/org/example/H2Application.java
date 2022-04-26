package org.example;

import org.example.dao.EmployeeRepository;
import org.example.model.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class H2Application implements CommandLineRunner {
    private EmployeeRepository employeeRepository;

    public H2Application(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(H2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Optional<Employee> optionalEmployee = employeeRepository.findById(10007);
        System.out.println(optionalEmployee);
        Long sumResult = employeeRepository.sumEmployeeNoByGender("M");
        System.out.println(sumResult);
    }
}
