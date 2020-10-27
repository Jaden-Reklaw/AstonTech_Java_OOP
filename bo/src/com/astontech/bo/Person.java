package com.astontech.bo;

import java.util.ArrayList;
import java.util.List;

public class Person extends BaseBO{
    //Properties
    // PersonId
    private int PersonId;
    // Title
    private String Title;
    // FirstName
    private String FirstName;
    // LastName
    private String LastName;
    // DisplayFirstName
    private String DisplayFirstName;
    // Gender
    private String Gender;
    // List of Email Objects
    private List<Email> Emails;
    //LIst of Vehicles
    private List<Vehicle> Vehicles;

    //Constructors
    public Person() {
        this.setEmails(new ArrayList<>());
        this.setVehicles(new ArrayList<>());
    }

    //Create setters and getters
    public void setPersonId(int personId) {
        this.PersonId = personId;
    }

    public int getPersonId() {
        return this.PersonId;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getFirstName() {
        return this.FirstName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setDisplayFirstName(String displayFirstName) {
        this.DisplayFirstName = displayFirstName;
    }

    public String getDisplayFirstName() {
        return this.DisplayFirstName;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    public String getGender() {
        return this.Gender;
    }

    public List<Email> getEmails() {
        return Emails;
    }

    public void setEmails(List<Email> emails) {
        Emails = emails;
    }

    public List<Vehicle> getVehicles() {
        return Vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        Vehicles = vehicles;
    }

    //Custom Methods
    //this will become an extension method
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public String GetFullName() {
        if(isNullOrEmpty(this.FirstName) && isNullOrEmpty(this.LastName)) {
            return "No Name Set";
        } else {
            if(isNullOrEmpty(this.FirstName)) {
                return this.LastName;
            } else if(isNullOrEmpty(this.LastName)) {
                return this.FirstName;
            } else {
                return this.FirstName + " " + this.LastName;
            }
        }
    }
}
