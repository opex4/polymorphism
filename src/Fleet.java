import java.util.ArrayList;
import java.util.List;

class Fleet {
    private List<Ship> ships = new ArrayList<>();

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public void showFleet() {
        if (ships.isEmpty()){
            System.out.println("Кораблей во флоте нет");
            return;
        }

        for (Ship ship : ships) {
            ship.move();
        }
    }

    public void showСharacteristics() {
        if (ships.isEmpty()){
            System.out.println("Кораблей во флоте нет");
            return;
        }

        for (Ship ship : ships) {
            ship.getCharacteristics();
        }
    }

    //Найти ледокол с наибольшим значением пробиваемого льда
    public void foundBestIcebreaker() {
        Icebreaker bestIcebreaker = null;

        //Нахождение максимального значения пробиваемого льда
        for (Ship ship : ships) {
            if (ship instanceof Icebreaker) {
                Icebreaker icebreaker = (Icebreaker) ship;
                if (bestIcebreaker == null || icebreaker.getIceThickness() > bestIcebreaker.getIceThickness()) {
                    bestIcebreaker = icebreaker;
                }
            }
        }

        //Вывод характеристик всех ледоколов с максимальным значением пробиваемого льда
        if (bestIcebreaker != null) {
            for (Ship ship : ships) {
                if (ship instanceof Icebreaker) {
                    Icebreaker icebreaker = (Icebreaker) ship;
                    if (icebreaker.getIceThickness() == bestIcebreaker.getIceThickness()) {
                        System.out.println("Лучший ледокол:");
                        icebreaker.getCharacteristics();
                    }
                }
            }
        } else {
            System.out.println("Ледоколов во флоте нет");
        }
    }
}
