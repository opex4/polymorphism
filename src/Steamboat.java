class Steamboat extends Ship {
    private int numBoilers;

    public Steamboat(String name, double tonnage, double speed, int numBoilers) {
        super(name, tonnage, speed);
        if (numBoilers < 0) {
            System.out.println("Количество котлов должно быть больше нуля");
            throw new IllegalArgumentException();
        }
        this.numBoilers = numBoilers;
    }

    @Override
    public void move() {
        System.out.println(name + " движется на паровом двигателе со скоростью " + speed + " узлов.");
    }

    @Override
    public void getСharacteristics(){
        System.out.println("Название: " + name + "\nСкорость: " + speed + " узлов" + "\nТоннаж: " + tonnage + "\nКоличество котлов: " + numBoilers + "\n");
    }
}
