class Steamboat extends Ship {
    public Steamboat(String name, double tonnage, double speed) {
        super(name, tonnage, speed);
    }

    @Override
    public void move() {
        System.out.println(name + " движется на паровом двигателе со скоростью " + speed + " узлов.");
    }
}
