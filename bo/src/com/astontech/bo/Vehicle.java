package com.astontech.bo;

import java.time.LocalDate;
import java.util.Date;

public class Vehicle extends BaseBO{
    //Params
    private int VehicleId;
    private VehicleModel Model;
    private LocalDate Year;
    private String VIN;

    //Constructors
    public Vehicle() {}
    public Vehicle(LocalDate year, String vin, VehicleModel model) {
        this.setYear(year);
        this.setVIN(vin);
        this.setModel(model);
    }

    //Setters and Getters
    public int getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(int vehicleId) {
        VehicleId = vehicleId;
    }

    public LocalDate getYear() {
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

    public VehicleModel getModel() {
        return Model;
    }

    public void setModel(VehicleModel model) {
        Model = model;
    }
}
