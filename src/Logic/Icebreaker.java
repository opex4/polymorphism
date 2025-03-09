package Logic;

public class Icebreaker extends Ship {
    private double iceThickness;

    public Icebreaker(String name, double tonnage, double speed, double iceThickness) {
        super(name, tonnage, speed);
        if (iceThickness < 0) {
            System.out.println("Толщина пробиваемого льда не может быть отрицательной");
            throw new IllegalArgumentException();
        }
        this.iceThickness = iceThickness;
        super.classShip = "Ледокол";
        getCharacteristics();
    }

    @Override
    public String move() {
        return (name + " пробивает лед со скоростью " + speed + " узлов.");
    }

    @Override
    public String getCharacteristics(){
        return ("Название: " + name + "\nКласс корабля: " + classShip + "\nСкорость: " + speed + " узлов" + "\nТоннаж: " + tonnage + "\nТолщина пробиваемого льда: " + iceThickness + " м" + "\n");
    }

    public double getIceThickness(){
        return this.iceThickness;
    }
}
