package org.example.repository;

import org.example.model.Employees;
import org.springframework.data.repository.CrudRepository;

public interface EmployeesRepository extends CrudRepository<Employees, Integer> {
}
