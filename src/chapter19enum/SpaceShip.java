package chapter19enum;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/30
 * Mail:zhengjun1987@outlook.com
 */
public enum SpaceShip {
    SCOUT,CARGO,TRANSPORT,CRUISER,BATTLESHIP,MOTHERSHIP;

    @Override
    public String toString() {
        String name = name();
        return name.charAt(0)+name.substring(1).toLowerCase();
    }

    public static void main(String[] args) {
        for (SpaceShip spaceShip : SpaceShip.values()) {
            System.out.println("spaceShip = " + spaceShip);
        }
    }
//    spaceShip = Scout
//            spaceShip = Cargo
//    spaceShip = Transport
//            spaceShip = Cruiser
//    spaceShip = Battleship
//            spaceShip = Mothership
}
