package com.astontech.bo;

public class Phone extends BaseBO{
    //Params
    private int PhoneId;
    private int AreaCode;
    private int PhoneNumber;
    private int PersonId;
    private int EntityTypeId;
    private int ClientId;

    //Constructors
    public Phone() {}
    public Phone(int areaCode, int phoneNumber) {
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

    public int getAreaCode() {
        return AreaCode;
    }

    public void setAreaCode(int areaCode) {
        AreaCode = areaCode;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
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
