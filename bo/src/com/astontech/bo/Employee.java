package com.astontech.bo;

import java.util.Date;

public class Employee extends Person{
    //region Properties
    private int EmployeeId;
    private String Email;
    private Date HireDate;
    private Date TermDate;
    private Date BirthDate;
    //don't need PersonID since inherited from Person Class
    //endregion

    //region Constructors
    public Employee() {} //Default constructor

    public Employee(String firstname) {
        this.setFirstName(firstname);
    }

    public Employee(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }
    //endregion

    //region Setters and Getters
    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
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

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    //endregion
}
