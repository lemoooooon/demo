package org.example.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Employees {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "emp_no")
    private int empNo;
    @Basic
    @Column(name = "birth_date")
    private Date birthDate;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "gender")
    private String gender;
    @Basic
    @Column(name = "hire_date")
    private Date hireDate;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return empNo == employees.empNo && Objects.equals(birthDate, employees.birthDate) && Objects.equals(firstName, employees.firstName) && Objects.equals(lastName, employees.lastName) && Objects.equals(gender, employees.gender) && Objects.equals(hireDate, employees.hireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, birthDate, firstName, lastName, gender, hireDate);
    }
}
