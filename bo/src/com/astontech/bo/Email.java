package com.astontech.bo;

public class Email extends BaseBO {
    //Param
    private int EmailId;
    private String EmailAddress;
    private int PersonId;
    private int EntityTypeId;

    //Constructors
    public Email() {}
    public Email(String emailAddress) {
        this.setEmailAddress(emailAddress);
    }

    //Setters and Getters
    public int getEmailId() {
        return EmailId;
    }

    public void setEmailId(int emailId) {
        EmailId = emailId;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }
}
