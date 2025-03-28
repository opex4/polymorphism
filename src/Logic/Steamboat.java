package Logic;

public class Steamboat extends Ship {
    private int numBoilers;

    public Steamboat(String name, double tonnage, double speed, int numBoilers) {
        super(name, tonnage, speed);
        if (numBoilers <= 0) {
            throw new IllegalArgumentException("Количество котлов должно быть больше нуля");
        }
        this.numBoilers = numBoilers;
        super.setClassShip("Пароход");
        getCharacteristics();
    }

    public int getNumBoilers() {
        return numBoilers;
    }

    @Override
    public String move() {
        return (getName() + " движется на паровом двигателе со скоростью " + getSpeed() + " узлов.");
    }

    @Override
    public String getCharacteristics(){
        return ("Название: " + getName() + "\nКласс корабля: " + getClassShip() + "\nСкорость: " + getSpeed() + " узлов" + "\nТоннаж: " + getTonnage()  + " т" + "\nКоличество котлов: " + numBoilers + "\n");
    }

    @Override
    public String getTableCharacteristics(){
        return (getName() + "," + getClassShip() + "," + getSpeed() + "," + getTonnage() + "," + getNumBoilers() + "\n");
    }
}
