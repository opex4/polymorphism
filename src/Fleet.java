import java.util.ArrayList;
import java.util.List;

class Fleet {
    private List<Ship> ships = new ArrayList<>();

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public void showFleet() {
        for (Ship ship : ships) {
            ship.move();
        }
    }

    public void showСharacteristics() {
        for (Ship ship : ships) {
            ship.getСharacteristics();
        }
    }
}
