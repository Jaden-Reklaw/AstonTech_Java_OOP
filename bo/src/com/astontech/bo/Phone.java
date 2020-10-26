package com.astontech.bo;

public class Phone extends BaseBO{
    //Params
    private int PhoneId;
    private String AreaCode;
    private String PhoneNumber;
    private String PhoneNumberPost;
    private int PersonId;
    private int EntityTypeId;
    private int ClientId;

    //Constructors
    public Phone() {}
    public Phone(String areaCode, String phoneNumber) {
        this.setAreaCode(areaCode);
        this.setPhoneNumber(phoneNumber);
    }

    //Setters and Getters
    public int getPhoneId() {
        return PhoneId;
    }

    public void setPhoneId(int phoneId) {
        PhoneId = phoneId;
    }

    public String getAreaCode() {
        return AreaCode;
    }

    public void setAreaCode(String areaCode) {
        AreaCode = areaCode;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPhoneNumberPost() {
        return PhoneNumberPost;
    }

    public void setPhoneNumberPost(String phoneNumberPost) {
        PhoneNumberPost = phoneNumberPost;
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

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }
}
