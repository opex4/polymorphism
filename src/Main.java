
public class Main {
    public static void main(String[] args) {
        Fleet fleet = new Fleet();
        fleet.addShip(new Steamboat("Титаник", 52310, 23));
        fleet.addShip(new SailingShip("Черная Жемчужина", 900, 15));
        fleet.addShip(new Icebreaker("Ямал", 23400, 18));

        fleet.showFleet();
    }
}