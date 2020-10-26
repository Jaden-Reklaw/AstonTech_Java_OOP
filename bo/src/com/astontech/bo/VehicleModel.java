package com.astontech.bo;

public class VehicleModel extends BaseBO{
    //Params
    private int VehicleModelId;
    private String VehicleModelName;
    private int VehicleMakeId;

    //Constructors
    public VehicleModel() {}
    public VehicleModel(String vehicleModelName) {
        this.setVehicleModelName(vehicleModelName);
    }

    //Setters and Getters
    public int getVehicleModelId() {
        return VehicleModelId;
    }

    public void setVehicleModelId(int vehicleModelId) {
        VehicleModelId = vehicleModelId;
    }

    public String getVehicleModelName() {
        return VehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        VehicleModelName = vehicleModelName;
    }

    public int getVehicleMakeId() {
        return VehicleMakeId;
    }

    public void setVehicleMakeId(int vehicleMakeId) {
        VehicleMakeId = vehicleMakeId;
    }
}
