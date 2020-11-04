package com.astontech.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import common.helpers.StringHelper;

public class Person extends BaseBO implements Comparable{
    //region Properties
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
    // IsDeleted
    private Boolean IsDeleted;
    // Gender
    private String Gender;
    // CreateDate
    private Date CreateDate;
    // List of Email Objects
    private List<Email> Emails;
    //LIst of Vehicles
    private List<Vehicle> Vehicles;
    //endregion

    //region Constructors
    public Person(int personId, String firstName) {
        this.setPersonId(personId);
        this.setFirstName(firstName);
    }

    public Person() {
        this.setEmails(new ArrayList<>());
        this.setVehicles(new ArrayList<>());
    }
    //endregion

    //region Setters and Getters
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

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }

    public Boolean getIsDeleted() {
        return IsDeleted;
    }

    public void setIsDeleted(Boolean deleted) {
        IsDeleted = deleted;
    }
    //endregion

    //region Person Methods
    public String GetFullName() {
        if(StringHelper.isNullOrEmpty(this.FirstName) && StringHelper.isNullOrEmpty(this.LastName)) {
            return "No Name Set";
        } else {
            if(StringHelper.isNullOrEmpty(this.FirstName)) {
                return this.LastName;
            } else if(StringHelper.isNullOrEmpty(this.LastName)) {
                return this.FirstName;
            } else {
                return this.FirstName + " " + this.LastName;
            }
        }
    }

    @Override
    public int compareTo(Object Person1) {
        Person Person2 = (Person) Person1;

        if(getPersonId() > Person2.getPersonId()) {
            return 1;
        } else if(getPersonId() < Person2.getPersonId()) {
            return -1;
        } else {
            return 0;
        }
    }
    //endregion
}
