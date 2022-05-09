package org.example.repository;

import org.example.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
    interface NameOnly {
        @Value("#{target.firstName + ' ' + target.lastName}")
        String getName();
    }

    Collection<NameOnly> findFullNameByGender(String gender);
}
