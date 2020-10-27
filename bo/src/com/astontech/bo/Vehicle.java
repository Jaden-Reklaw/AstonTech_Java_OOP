package com.astontech.bo;

import java.time.LocalDate;
import java.util.Date;

public class Vehicle extends BaseBO{
    //Params
    private int VehicleId;
    private int VehicleModelId;
    private LocalDate Year;
    private String VIN;

    //Constructors
    public Vehicle() {}
    public Vehicle(LocalDate year, String vin) {
        this.setYear(year);
        this.setVIN(vin);
    }

    //Setters and Getters
    public int getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(int vehicleId) {
        VehicleId = vehicleId;
    }

    public int getVehicleModelId() {
        return VehicleModelId;
    }

    public void setVehicleModelId(int vehicleModelId) {
        VehicleModelId = vehicleModelId;
    }

    public Date getYear() {
        return Year;
    }

    public void setYear(LocalDate year) {
        Year = year;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }
}
