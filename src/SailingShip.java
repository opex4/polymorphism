class SailingShip extends Ship {
    public SailingShip(String name, double tonnage, double speed) {
        super(name, tonnage, speed);
    }

    @Override
    public void move() {
        System.out.println(name + " движется под парусами со скоростью " + speed + " узлов.");
    }
}
