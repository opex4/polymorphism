class Icebreaker extends Ship {
    public Icebreaker(String name, double tonnage, double speed) {
        super(name, tonnage, speed);
    }

    @Override
    public void move() {
        System.out.println(name + " пробивает лед со скоростью " + speed + " узлов.");
    }
}
