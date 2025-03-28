package Logic;

public abstract class Ship {
    private String classShip;
    private String name;
    private double tonnage;
    private double speed;

    public Ship(String name, double tonnage, double speed) throws IllegalArgumentException {
        if (!name.matches("[A-ZА-Я][a-zа-я]*") && !name.matches("[A-ZА-Я][a-zа-я]*(\s[A-ZА-Я][a-zа-я]*)*")) {
            throw new IllegalArgumentException("Некорректное название корабля:\n1.Начало каждого слова с заглавной буквы\n2.Слова разделены пробелами\n3.Использовать можно только буквы");
        }
        if (tonnage <= 0) {
            throw new IllegalArgumentException("Тоннаж не может быть отрицательным или равным нулю");
        }
        if (speed <= 0) {
            throw new IllegalArgumentException("Скорость не может быть отрицательной или равной нулю");
        }
        this.name = name;
        this.tonnage = tonnage;
        this.speed = speed;
    }

    protected void setClassShip(String classShip) {
        this.classShip = classShip;
    }

    public String getClassShip(){ return classShip; }
    public String getName() { return name; }
    public double getTonnage() { return tonnage; }
    public double getSpeed() { return speed; }

    public abstract String move();
    public abstract String getCharacteristics();
    public abstract String getTableCharacteristics();
}