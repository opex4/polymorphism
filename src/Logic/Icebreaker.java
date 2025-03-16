package Logic;

public class Icebreaker extends Ship {
    private double iceThickness;

    public Icebreaker(String name, double tonnage, double speed, double iceThickness) {
        super(name, tonnage, speed);
        if (iceThickness <= 0) {
            throw new IllegalArgumentException("Толщина пробиваемого льда должна быть больше нуля");
        }
        this.iceThickness = iceThickness;
        super.setClassShip("Ледокол");
        getCharacteristics();
    }

    @Override
    public String move() {
        return (getName() + " пробивает лед со скоростью " + getSpeed() + " узлов.");
    }

    @Override
    public String getCharacteristics(){
        return ("Название: " + getName() + "\nКласс корабля: " + getClassShip() + "\nСкорость: " + getSpeed() + " узлов" + "\nТоннаж: " + getTonnage() + "\nТолщина пробиваемого льда: " + iceThickness + " м" + "\n");
    }

    public double getIceThickness(){
        return this.iceThickness;
    }
}
