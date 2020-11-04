package com.astontech.bo;

import java.util.Date;

public class Employee extends Person{
    //Parameters
    private int EmployeeId;
    private String Email;
    private Date DOB;
    private Date HireDate;
    private Date TermDate;

    //Constructor
    public Employee() {} //Default constructor

    public Employee(String firstname) {
        this.setFirstName(firstname);
    }

    public Employee(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    //region Setters and Getters
    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public Date getHireDate() {
        return HireDate;
    }

    public void setHireDate(Date hireDate) {
        HireDate = hireDate;
    }

    public Date getTermDate() {
        return TermDate;
    }

    public void setTermDate(Date termDate) {
        TermDate = termDate;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }
    //endregion
}
