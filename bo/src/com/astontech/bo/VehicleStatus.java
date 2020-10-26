package com.astontech.bo;

public class VehicleStatus extends BaseBO{
    //Params
    private int VehicleStatusId;
    private boolean VehicleStatusValue;
    private String Notes;
    private int VehicleId;
    private int EntityTypeId;

    //Constructors
    public VehicleStatus() {}
    public VehicleStatus(boolean vehicleStatusValue) {
        this.setVehicleStatusValue(vehicleStatusValue);
    }

    //Setters and Getters
    public int getVehicleStatusId() {
        return VehicleStatusId;
    }

    public void setVehicleStatusId(int vehicleStatusId) {
        VehicleStatusId = vehicleStatusId;
    }

    public boolean isVehicleStatusValue() {
        return VehicleStatusValue;
    }

    public void setVehicleStatusValue(boolean vehicleStatusValue) {
        VehicleStatusValue = vehicleStatusValue;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
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
}
