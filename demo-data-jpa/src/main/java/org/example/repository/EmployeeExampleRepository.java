package org.example.repository;

import org.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeExampleRepository extends JpaRepository<Employee, Integer> {
}
