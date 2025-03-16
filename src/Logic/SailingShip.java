package Logic;

public class SailingShip extends Ship {
    private double maxWindageFactor;

    public SailingShip(String name, double tonnage, double speed, double maxWindageFactor) {
        super(name, tonnage, speed);
        if (maxWindageFactor <= 0) {
            throw new IllegalArgumentException("Максимальный коэффициент парусности должен быть больше нуля");
        }
        this.maxWindageFactor = maxWindageFactor;
        super.setClassShip("Парусник");
        getCharacteristics();
    }

    @Override
    public String move() {
        return (getName() + " движется под парусами со скоростью " + getSpeed() + " узлов.");
    }

    @Override
    public String getCharacteristics(){
        return ("Название: " + getName() + "\nКласс корабля: " + getClassShip() + "\nСкорость: " + getSpeed() + " узлов" + "\nТоннаж: " + getTonnage() + "\nМаксимальный коэффициент парусности: " + maxWindageFactor + " кв. м" + "\n");
    }
}
