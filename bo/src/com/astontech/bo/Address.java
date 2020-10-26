package com.astontech.bo;

public class Address extends BaseBO{
    //Params
    private int AddressId;
    private String Street;
    private String Street02;
    private String City;
    private String StateId;
    private String ZipCode;
    private String ZipCodePost;
    private int CountryId;
    private int PersonId;
    private int EntityTypeId;
    private int ClientId;

    //Constructor
    public Address() {}
    public Address(String street, String city, String stateId, String zipCode) {
        this.setStreet(street);
        this.setCity(city);
        this.setStateId(stateId);
        this.setZipCode(zipCode);
    }

    //Setters and Getters
    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int addressId) {
        AddressId = addressId;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getStreet02() {
        return Street02;
    }

    public void setStreet02(String street02) {
        Street02 = street02;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStateId() {
        return StateId;
    }

    public void setStateId(String stateId) {
        StateId = stateId;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }

    public String getZipCodePost() {
        return ZipCodePost;
    }

    public void setZipCodePost(String zipCodePost) {
        ZipCodePost = zipCodePost;
    }

    public int getCountryId() {
        return CountryId;
    }

    public void setCountryId(int countryId) {
        CountryId = countryId;
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

    public String ShowFullAddress() {
        return (this.getStreet() + " " +  this.getCity() + " " + this.getStateId() + " " + this.getZipCode());
    }
}
