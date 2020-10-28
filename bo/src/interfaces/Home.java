package interfaces;

import com.astontech.bo.Employee;

public class Home implements ILocation{
    //region Properties
    private String Address;
    private Employee Owner;
    //endregion

    //region Getters / Setters
    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Employee getOwner() {
        return Owner;
    }

    public void setOwner(Employee owner) {
        Owner = owner;
    }
    //endregion

    //region Overrides from interface

    @Override
    public int numberOfWorkSpaces() {
        return 1;
    }

    @Override
    public boolean canHaveMeetings() {
        return false;
    }

    @Override
    public String getLocationName() {
        return this.Owner.getFirstName() + "'s Home";
    }

    @Override
    public boolean hasCoffee() {
        return true;
    }
    //endregion
}
