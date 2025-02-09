class SailingShip extends Ship {
    private double maxWindageFactor;

    public SailingShip(String name, double tonnage, double speed, double maxWindageFactor) {
        super(name, tonnage, speed);
        if (maxWindageFactor <= 0) {
            System.out.println("Максимальный коэффициент парусности должен быть больше нуля");
            throw new IllegalArgumentException();
        }
        this.maxWindageFactor = maxWindageFactor;
    }

    @Override
    public void move() {
        System.out.println(name + " движется под парусами со скоростью " + speed + " узлов.");
    }

    @Override
    public void getСharacteristics(){
        System.out.println("Название: " + name + "\nСкорость: " + speed + " узлов" + "\nТоннаж: " + tonnage + "\nМаксимальный коэффициент парусности: " + maxWindageFactor + " кв. м" + "\n");
    }
}
