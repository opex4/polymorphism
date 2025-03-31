package Logic;

public class SailingShip extends Ship {
    private final double maxWindageFactor;

    public SailingShip(String name, double tonnage, double speed, double maxWindageFactor) {
        super(name, tonnage, speed);
        if (maxWindageFactor <= 0) {
            throw new IllegalArgumentException("Максимальный коэффициент парусности должен быть больше нуля");
        }
        this.maxWindageFactor = maxWindageFactor;
        super.setClassShip("Парусник");
        getCharacteristics();
    }

    public double getMaxWindageFactor() {
        return maxWindageFactor;
    }

    @Override
    public String move() {
        return (getName() + " движется под парусами со скоростью " + getSpeed() + " узлов.");
    }

    @Override
    public String getCharacteristics(){
        return ("Название: " + getName() + "\nКласс корабля: " + getClassShip() + "\nСкорость: " + getSpeed() + " узлов" + "\nТоннаж: " + getTonnage() + " т" + "\nМаксимальный коэффициент парусности: " + maxWindageFactor + " кв. м" + "\n");
    }

    @Override
    public String getTableCharacteristics(){
        return (getName() + "," + getClassShip() + "," + getSpeed() + "," + getTonnage() + "," + getMaxWindageFactor() + "\n");
    }
}
