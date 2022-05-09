package org.example.repository;

import org.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaEmployeeRepository implements EmployeeRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Employee findEmployeeByEmpNo(Integer empNo) {
        Employee employee = new Employee();
        em.persist(employee);
        return employee;
    }

    @Override
    public Long sumEmployeeNoByGender(String gender) {
        return null;
    }

    @Override
    public Page<Employee> findAllByFirstNameIsLike(String firstName, Pageable pageable) {
        return null;
    }

    @Override
    public List<Employee> findAllByLastNameIsLike(String firstName, Pageable pageable) {
        return null;
    }

    @Override
    public List<Employee> findAllByEmpNo(Integer empNo, Sort sort) {
        return null;
    }

    @Override
    public Employee myEmployeeMethod() {
        return null;
    }

    @Override
    public Optional<Employee> findOne(Specification<Employee> spec) {
        return Optional.empty();
    }

    @Override
    public List<Employee> findAll(Specification<Employee> spec) {
        return null;
    }

    @Override
    public Page<Employee> findAll(Specification<Employee> spec, Pageable pageable) {
        return null;
    }

    @Override
    public List<Employee> findAll(Specification<Employee> spec, Sort sort) {
        return null;
    }

    @Override
    public long count(Specification<Employee> spec) {
        return 0;
    }

    @Override
    public <S extends Employee> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Employee> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Employee> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Employee> findAll() {
        return null;
    }

    @Override
    public Iterable<Employee> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Employee entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Employee> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
