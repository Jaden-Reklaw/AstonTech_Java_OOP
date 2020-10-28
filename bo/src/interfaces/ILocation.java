package interfaces;

public interface ILocation {
    //interfaces can have required properties or methods
    public double PI = 3.14; //You can't leave it without a value

    public int numberOfWorkSpaces();

    public boolean canHaveMeetings();

    public String getLocationName();

    public boolean hasCoffee();
}
