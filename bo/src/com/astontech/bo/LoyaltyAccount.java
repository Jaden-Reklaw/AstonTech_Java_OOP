package com.astontech.bo;

public class LoyaltyAccount extends BaseBO{
    //Params
    private int LoyaltyCompanyId;
    private int EmployeeId;
    private int EmployeeTypeId;
    private int LoyaltyAccountId;
    private int MemberNumber;

    //Constructors
    public LoyaltyAccount() {}
    public LoyaltyAccount(int loyaltyAccountId) {
        this.setLoyaltyAccountId(loyaltyAccountId);
    }

    //Setters and Getters
    public int getLoyaltyCompanyId() {
        return LoyaltyCompanyId;
    }

    public void setLoyaltyCompanyId(int loyaltyCompanyId) {
        LoyaltyCompanyId = loyaltyCompanyId;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public int getEmployeeTypeId() {
        return EmployeeTypeId;
    }

    public void setEmployeeTypeId(int employeeTypeId) {
        EmployeeTypeId = employeeTypeId;
    }

    public int getLoyaltyAccountId() {
        return LoyaltyAccountId;
    }

    public void setLoyaltyAccountId(int loyaltyAccountId) {
        LoyaltyAccountId = loyaltyAccountId;
    }

    public int getMemberNumber() {
        return MemberNumber;
    }

    public void setMemberNumber(int memberNumber) {
        MemberNumber = memberNumber;
    }
}
