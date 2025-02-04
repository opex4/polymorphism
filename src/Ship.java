abstract class Ship {
    protected String name;
    protected double tonnage;
    protected double speed;

    public Ship(String name, double tonnage, double speed) {
        this.name = name;
        this.tonnage = tonnage;
        this.speed = speed;
    }

    public String getName() { return name; }
    public double getTonnage() { return tonnage; }
    public double getSpeed() { return speed; }

    public abstract void move();
}
