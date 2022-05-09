package org.example;

import org.example.model.Employee;
import org.example.repository.EmployeeExampleRepository;
import org.example.repository.EmployeeRepository;
import org.example.repository.EmployeeSpecificationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;

import javax.persistence.criteria.Predicate;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class RepositoryApplication implements CommandLineRunner {

    private final EmployeeRepository repository;
    private final EmployeeExampleRepository exampleRepository;
    private final EmployeeSpecificationRepository specificationRepository;

    public RepositoryApplication(EmployeeRepository repository, EmployeeExampleRepository exampleRepository, EmployeeSpecificationRepository specificationRepository) {
        this.repository = repository;
        this.exampleRepository = exampleRepository;
        this.specificationRepository = specificationRepository;
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
        employee.setGender("M");
        repository.save(employee);

        Collection<EmployeeRepository.NameOnly> result = repository.findFullNameByGender("M");
        System.out.println(result);

        Employee example = new Employee();
        employee.setGender("F");
        Iterable<Employee> exampleResult = exampleRepository.findAll(Example.of(example));
        System.out.println(exampleResult);

        specificationRepository.findAll((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            Predicate p1 = builder.equal(root.get("gender"), "M");
            Predicate p2 = builder.equal(root.get("name"), "Anneke");
            Predicate p = builder.and(p1, p2);
            predicates.add(p);
            return query.where(predicates.toArray(new Predicate[0]));
        })
    }
}
