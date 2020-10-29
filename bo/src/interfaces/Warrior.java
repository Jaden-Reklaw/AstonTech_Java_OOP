package interfaces;

public class Warrior implements Player{
    //region Properties
    private String Name;
    private String FamilyCrest;
    private String UltimateAttack;
    private String Type;
    //endregion

    //region Constructors
    public Warrior() {}
    public Warrior(String name, String familyCrest, String ultimateAttack, String type) {
        this.setName(name);
        this.setFamilyCrest(familyCrest);
        this.setUltimateAttack(ultimateAttack);
        this.setType(type);
    }
    //endregion

    //region Required methods from Player Interface
    @Override
    public int move() {
        return 5;
    }

    @Override
    public boolean jump() {
        return true;
    }

    @Override
    public String attack() {
        return "In the Name of " + this.getFamilyCrest() + " I " + this.getName() +
                "will smite you down with " + this.getUltimateAttack();
    }

    @Override
    public String eat() {
        return "Bring Beer and Meat!";
    }

    @Override
    public String sleep() {
        return "Sleep is for the weak!";
    }
    //endregion

    //region Setters and Getters
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFamilyCrest() {
        return FamilyCrest;
    }

    public void setFamilyCrest(String familyCrest) {
        FamilyCrest = familyCrest;
    }

    public String getUltimateAttack() {
        return UltimateAttack;
    }

    public void setUltimateAttack(String ultimateAttack) {
        UltimateAttack = ultimateAttack;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
    //endregion
}
