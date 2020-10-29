package interfaces;

public class Wizard implements Player{
    //region Properties
    private String Name;
    private String Attackname;
    private String Type;
    //endregion

    //region Constructors
    public Wizard() {}
    public Wizard(String name, String attackname, String type) {
        this.setName(name);
        this.setAttackname(attackname);
        this.setType(type);
    }
    //endregion

    //region Required Methods from Player Interface
    @Override
    public int move() {
        return 2;
    }

    @Override
    public boolean jump() {
        return false;
    }

    @Override
    public String attack() {
        return this.getName() + " attacks with " + this.getAttackname();
    }

    @Override
    public String eat() {
        return "Num Num for my tum tum!";
    }

    @Override
    public String sleep() {
        return "Zzz Zzz!";
    }
    //endregion

    //region Setters and Getters
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAttackname() {
        return Attackname;
    }

    public void setAttackname(String attackname) {
        Attackname = attackname;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
    //endregion
}
