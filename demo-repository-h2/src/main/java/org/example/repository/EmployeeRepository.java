package org.example.repository;

import org.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * JPA的查询方法：
 * 1. @Query注解手动定义查询
 * 2. 由方法名衍生查询，如findEmployeeByXXX。ByEmpNoAndFirstNameAndLastName会构建employee.empNo.firstName.lastName这样的属性遍历。属性表达式
 * 3.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer>, JpaSpecificationExecutor<Employee>, EmployeeRepositoryEmployee {
    Employee findEmployeeByEmpNo(Integer empNo);

    @Query(value = "select sum(emp_no) from employee " +
            "where gender = ?1" +
            "",nativeQuery = true)
    Long sumEmployeeNoByGender(String gender);

    Page<Employee> findAllByFirstNameIsLike(String firstName, Pageable pageable);
    List<Employee> findAllByLastNameIsLike(String firstName, Pageable pageable);
    List<Employee> findAllByEmpNo(Integer empNo, Sort sort);
}
