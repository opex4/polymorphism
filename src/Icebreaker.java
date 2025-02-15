class Icebreaker extends Ship {
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
    public void move() {
        System.out.println(name + " пробивает лед со скоростью " + speed + " узлов.");
    }

    @Override
    public void getCharacteristics(){
        System.out.println("Название: " + name + "\nКласс корабля: " + classShip + "\nСкорость: " + speed + " узлов" + "\nТоннаж: " + tonnage + "\nТолщина пробиваемого льда: " + iceThickness + " м" + "\n");
    }

    @Override
    public String getClassShip(){
        return this.classShip;
    }

    public double getIceThickness(){
        return this.iceThickness;
    }
}
