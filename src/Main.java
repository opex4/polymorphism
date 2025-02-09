
public class Main {
    public static void main(String[] args) {
        try {
            Fleet fleet = new Fleet();
            fleet.addShip(new Steamboat("Титаник", 52310, 23, 4));
            fleet.addShip(new SailingShip("Черная Жемчужина", 900, 15, 1200));
            fleet.addShip(new Icebreaker("Ямал", 23400, 18, 4));
            fleet.showFleet();
            System.out.println();
            fleet.showСharacteristics();
        } catch (IllegalArgumentException e){
            System.out.println("Попробуйте заново");
        }
    }
}