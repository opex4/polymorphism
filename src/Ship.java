abstract class Ship {
    protected String classShip;
    protected String name;
    protected double tonnage;
    protected double speed;

    public Ship(String name, double tonnage, double speed) throws IllegalArgumentException {
        if (!name.matches("[A-ZА-Я][a-zа-я]*") && !name.matches("[A-ZА-Я][a-zа-я]*(\s[A-ZА-Я][a-zа-я]*)*")) {
            System.out.println("Некорректное название корабля:\n1.Начало каждого слова с заглавной буквы\n2.Слова разделены пробелами\n3.Использовать можно только буквы");
            throw new IllegalArgumentException();
        }
        if (tonnage <= 0) {
            System.out.println("Тоннаж не может быть отрицательным или равным нулю");
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.tonnage = tonnage;
        this.speed = speed;
    }

    public String getName() { return name; }
    public double getTonnage() { return tonnage; }
    public double getSpeed() { return speed; }

    public abstract void move();
    public abstract void getCharacteristics();
}
