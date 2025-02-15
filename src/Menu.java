import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;



public class Menu {
    static private Scanner scannerNum = new Scanner(System.in);
    static private Scanner scannerLine = new Scanner(System.in);
    static private Fleet fleet = new Fleet();


    //Считать с консоли число
    private static int getInteger() {
        int result = 0;
        while (true) {
            try {
                result = scannerNum.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Неверно введено число\nПопробуйте снова");
                scannerNum.next();
            } catch (NoSuchElementException e) {
                System.out.println("Введено пустое значение\nПопробуйте снова");
                scannerNum.next();
            }
        }
        return result;
    }

    //Считать с консоли число
    private static double getDouble() {
        double result;
        while (true) {
            try {
                result = scannerNum.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Неверно введено число\nПопробуйте снова");
                scannerNum.next();
            } catch (NoSuchElementException e) {
                System.out.println("Введено пустое значение\nПопробуйте снова");
                scannerNum.next();
            }
        }
        return result;
    }

    // Считать строку из консоли
    private static String getConsoleLine() {
        String line;
        while (true) {
            try {
                line = scannerLine.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Ошибка чтения с консоли");
                scannerLine.nextLine();
            }
        }
        return line;
    }

    // Старт меню
    public static void startMenu() {
        int task = 0;
        while (task != 3) {
            while (task != 1 && task != 2 && task != 3 && task != 4 && task != 5) {
                System.out.println("Введите номер задачи:\n\t1.Добавить корабль\n\t2.Показать флот\n\t3.Вывести характеристики кораблей\n\t4.Найти ледокол с наибольшим значением пробиваемого льда\n\t5.Закончить работу");
                task = getInteger();
            }
            switch (task) {
                case 1:
                    addShip();
                    task = 0;
                    break;
                case 2:
                    fleet.showFleet();
                    task = 0;
                    break;
                case 3:
                    fleet.showСharacteristics();
                    task = 0;
                    break;
                case 4:
                    fleet.foundBestIcebreaker();
                    task = 0;
                    break;
                case 5:
                    exitProgram();
                    return;
                default:
                    System.out.println("Неверно введён номер задачи");
            }
        }
    }

    //Добавить корабль
    private static void addShip(){
        int task = 0;
        while (task != 1 && task != 2 && task != 3 && task != 4 && task != 5) {
            System.out.println("Введите номер класса добавляемого корабля:\n\t1.Ледокол\n\t2.Парусник\n\t3.Теплоход");
            task = getInteger();
        }
        switch (task) {
            case 1:
                addIcebreaker();
                break;
            case 2:
                addSailingShip();
                break;
            case 3:
                addSteamboat();
                break;
            default:
                System.out.println("Неверно введён номер класса корабля");
        }
    }

    //Добавить ледокол
    public static void addIcebreaker(){
        try {
            System.out.println("Введите название корабля:");
            String name = getConsoleLine();
            System.out.println("Введите тоннаж");
            double tonnage = getDouble();
            System.out.println("Введите скорость");
            double speed = getDouble();
            System.out.println("Введите толщину пробиваемого льда");
            double iceThickness = getDouble();
            fleet.addShip(new Icebreaker(name, tonnage, speed, iceThickness));
        } catch (IllegalArgumentException e){
            System.out.println("Попробуйте заново");
        }
    }

    //Добавить парусник
    public static void addSailingShip(){
        try {
            System.out.println("Введите название корабля:");
            String name = getConsoleLine();
            System.out.println("Введите тоннаж");
            double tonnage = getDouble();
            System.out.println("Введите скорость");
            double speed = getDouble();
            System.out.println("Введите максимальный коэффициент парусности");
            double maxWindageFactor = getDouble();
            fleet.addShip(new SailingShip(name, tonnage, speed, maxWindageFactor));
        } catch (IllegalArgumentException e){
            System.out.println("Попробуйте заново");
        }
    }

    //Добавить теплоход
    public static void addSteamboat(){
        try {
            System.out.println("Введите название корабля:");
            String name = getConsoleLine();
            System.out.println("Введите тоннаж");
            double tonnage = getDouble();
            System.out.println("Введите скорость");
            double speed = getDouble();
            System.out.println("Введите количество котлов");
            int numBoilers = getInteger();
            fleet.addShip(new Steamboat(name, tonnage, speed, numBoilers));
        } catch (IllegalArgumentException e){
            System.out.println("Попробуйте заново");
        }
    }

    //Конец программы
    private static void exitProgram() {
        System.out.println("Работа программы завершена");
        scannerNum.close();
    }
}