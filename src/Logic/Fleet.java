package Logic;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private List<Ship> ships = new ArrayList<>();

    // Метод для добавления корабля в флот
    public void addShip(Ship ship) {
        ships.add(ship);
    }

    // Метод для вывода флота
    public String showFleet() {
        if (ships.isEmpty()) {
            return "Кораблей во флоте нет";
        }
        StringBuilder result = new StringBuilder();
        for (Ship ship : ships) {
            result.append(ship.move()).append("\n");
        }
        return result.toString();
    }

    // Метод для вывода характеристик флота
    public String showCharacteristics() {
        if (ships.isEmpty()) {
            return "Кораблей во флоте нет";
        }
        StringBuilder result = new StringBuilder();
        for (Ship ship : ships) {
            result.append(ship.getCharacteristics()).append("\n");
        }
        return result.toString();
    }

    // Метод для вывода характеристик флота
    public String showTableCharacteristics() {
        if (ships.isEmpty()) {
            return "Кораблей во флоте нет";
        }
        StringBuilder result = new StringBuilder();
        for (Ship ship : ships) {
            result.append(ship.getTableCharacteristics());
        }
        return result.toString();
    }

    // Найти ледокол с наибольшим значением пробиваемого льда
    public String foundBestIcebreaker() {
        Icebreaker bestIcebreaker = null;

        // Нахождение максимального значения пробиваемого льда
        for (Ship ship : ships) {
            if (ship instanceof Icebreaker) {
                Icebreaker icebreaker = (Icebreaker) ship;
                if (bestIcebreaker == null || icebreaker.getIceThickness() > bestIcebreaker.getIceThickness()) {
                    bestIcebreaker = icebreaker;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        // Вывод характеристик всех ледоколов с максимальным значением пробиваемого льда
        if (bestIcebreaker != null) {
            for (Ship ship : ships) {
                if (ship instanceof Icebreaker) {
                    Icebreaker icebreaker = (Icebreaker) ship;
                    if (icebreaker.getIceThickness() == bestIcebreaker.getIceThickness()) {
                        result.append("Лучший ледокол:\n").append(icebreaker.getCharacteristics()).append("\n");
                    }
                }
            }
            return result.toString();
        } else {
            return "Ледоколов во флоте нет";
        }
    }

    // Найти ледокол с наибольшим значением пробиваемого льда для таблицы
    public String foundBestIcebreakerTable() {
        Icebreaker bestIcebreaker = null;

        // Нахождение максимального значения пробиваемого льда
        for (Ship ship : ships) {
            if (ship instanceof Icebreaker) {
                Icebreaker icebreaker = (Icebreaker) ship;
                if (bestIcebreaker == null || icebreaker.getIceThickness() > bestIcebreaker.getIceThickness()) {
                    bestIcebreaker = icebreaker;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        // Вывод характеристик всех ледоколов с максимальным значением пробиваемого льда
        if (bestIcebreaker != null) {
            for (Ship ship : ships) {
                if (ship instanceof Icebreaker) {
                    Icebreaker icebreaker = (Icebreaker) ship;
                    if (icebreaker.getIceThickness() == bestIcebreaker.getIceThickness()) {
                        result.append(icebreaker.getTableCharacteristics());
                    }
                }
            }
            return result.toString();
        } else {
            return "Ледоколов во флоте нет";
        }
    }
}
