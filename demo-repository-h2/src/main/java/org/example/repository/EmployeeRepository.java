package org.example.repository;

import org.example.model.Employee;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
    @Query(value = "select sum(emp_no) from employee " +
            "where gender = ?1" +
            "",nativeQuery = true)
    Long sumEmployeeNoByGender(String gender);
}
