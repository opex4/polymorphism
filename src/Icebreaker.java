class Icebreaker extends Ship {
    private double iceThickness;

    public Icebreaker(String name, double tonnage, double speed, double iceThickness) {
        super(name, tonnage, speed);
        if (iceThickness < 0) {
            System.out.println("Толщина пробиваемого льда не может быть отрицательной");
            throw new IllegalArgumentException();
        }
        this.iceThickness = iceThickness;
    }

    @Override
    public void move() {
        System.out.println(name + " пробивает лед со скоростью " + speed + " узлов.");
    }

    @Override
    public void getСharacteristics(){
        System.out.println("Название: " + name + "\nСкорость: " + speed + " узлов" + "\nТоннаж: " + tonnage + "\nТолщина пробиваемого льда: " + iceThickness + " м" + "\n");
    }
}
