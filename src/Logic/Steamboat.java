package Logic;

public class Steamboat extends Ship {
    private int numBoilers;

    public Steamboat(String name, double tonnage, double speed, int numBoilers) {
        super(name, tonnage, speed);
        if (numBoilers < 0) {
            System.out.println("Количество котлов должно быть больше нуля");
            throw new IllegalArgumentException();
        }
        this.numBoilers = numBoilers;
        super.classShip = "Пароход";
        getCharacteristics();
    }

    @Override
    public String move() {
        return (name + " движется на паровом двигателе со скоростью " + speed + " узлов.");
    }

    @Override
    public String getCharacteristics(){
        return ("Название: " + name + "\nКласс корабля: " + classShip + "\nСкорость: " + speed + " узлов" + "\nТоннаж: " + tonnage + "\nКоличество котлов: " + numBoilers + "\n");
    }
}
