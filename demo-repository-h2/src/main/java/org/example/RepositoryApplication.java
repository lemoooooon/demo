package org.example;

import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class RepositoryApplication implements CommandLineRunner {

    private final EmployeeRepository repository;

    public RepositoryApplication(EmployeeRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(RepositoryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee();
        employee.setBirthDate(Date.valueOf(LocalDate.now()));
        employee.setFirstName("fn");
        employee.setLastName("ln");
        employee.setGender("Male");
        repository.save(employee);
        System.out.println(repository.sumEmployeeNoByGender("Male"));
        System.out.println(repository.findEmployeeByEmpNo(2));

        Pageable pageable = new PageRequest(2, 10, Sort.Direction.ASC, "lastname", "firstname");
        repository.findAllByLastNameIsLike("San", pageable);
        Sort sort = new Sort(Sort.Direction.DESC, "Matthews");
        List<Employee> result = repository.findAllByEmpNo(2, sort);
    }
}
