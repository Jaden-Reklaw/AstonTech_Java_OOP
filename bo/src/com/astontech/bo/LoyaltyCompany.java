package com.astontech.bo;

public class LoyaltyCompany extends BaseBO{
    //Params
    private int LoyaltyCompanyId;
    private String LoyaltyCompanyName;

    //Constructors
    public LoyaltyCompany() {}
    public LoyaltyCompany(String loyaltyCompanyName) {
        this.setLoyaltyCompanyName(loyaltyCompanyName);
    }

    public int getLoyaltyCompanyId() {
        return LoyaltyCompanyId;
    }

    public void setLoyaltyCompanyId(int loyaltyCompanyId) {
        LoyaltyCompanyId = loyaltyCompanyId;
    }

    public String getLoyaltyCompanyName() {
        return LoyaltyCompanyName;
    }

    public void setLoyaltyCompanyName(String loyaltyCompanyName) {
        LoyaltyCompanyName = loyaltyCompanyName;
    }
}
