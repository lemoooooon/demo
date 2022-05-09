package org.example.repository;

import org.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmployeeSpecificationRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
}
