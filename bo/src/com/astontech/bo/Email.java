package com.astontech.bo;

public class Email extends BaseBO {
    //Param
    private int EmailId;
    private String EmailAddress;
    private EntityType EmailType; //Nest object in another object

    //Constructors
    public Email() {
        this.setEmailType(new EntityType());
    }

    public Email(String emailAddress) {
        this.setEmailType(new EntityType());
        this.EmailAddress = emailAddress;
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


    public EntityType getEmailType() {
        return EmailType;
    }

    public void setEmailType(EntityType emailType) {
        EmailType = emailType;
    }
}
