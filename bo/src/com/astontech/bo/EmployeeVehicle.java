package com.astontech.bo;

import java.util.Date;

public class EmployeeVehicle extends BaseBO{
    //Params
    private int EmployeeVehicleId;
    private int EmployeeId;
    private int VehicleId;
    private int EntityTypeId;
    private Date AssignedDate;

    //Constructor
    public EmployeeVehicle() {}
    public EmployeeVehicle(Date assignedDate) {
        this.setAssignedDate(assignedDate);
    }

    //Setters and Getters
    public int getEmployeeVehicleId() {
        return EmployeeVehicleId;
    }

    public void setEmployeeVehicleId(int employeeVehicleId) {
        EmployeeVehicleId = employeeVehicleId;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public int getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(int vehicleId) {
        VehicleId = vehicleId;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public Date getAssignedDate() {
        return AssignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        AssignedDate = assignedDate;
    }
}
