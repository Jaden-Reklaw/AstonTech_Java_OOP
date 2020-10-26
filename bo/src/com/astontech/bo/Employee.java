package com.astontech.bo;

import java.util.Date;

public class Employee extends Person{
    private int EmployeeId;
    private Date HireDate;
    private Date TermDate;


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
}
