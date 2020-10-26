package com.astontech.bo;

public class VehicleMake extends BaseBO{
    //Params
    private int VehicleMakeId;
    private String VehicleMakeName;

    //Constructors
    public VehicleMake() {}
    public  VehicleMake(String vehicleMakeName) {
        this.setVehicleMakeName(vehicleMakeName);
    }

    //Setters and Getters
    public int getVehicleMakeId() {
        return VehicleMakeId;
    }

    public void setVehicleMakeId(int vehicleMakeId) {
        VehicleMakeId = vehicleMakeId;
    }

    public String getVehicleMakeName() {
        return VehicleMakeName;
    }

    public void setVehicleMakeName(String vehicleMakeName) {
        VehicleMakeName = vehicleMakeName;
    }
}
