package pl.jdomanski.bgames;

import pl.jdomanski.bgames.ships.*;

public class ShipsGame {

    public static void main(String[] args) {

        Grid ownGrid = new Grid(10, 10);
        Grid enemyGrid = new Grid(10, 10);

        ShipPlacer shipPlacer = new ShipPlacerImpl();

        shipPlacer.createAndPlaceFleetAt(ownGrid);
        shipPlacer.createAndPlaceFleetAt(enemyGrid);

        ShipsBoard ownBoard = new ShipsBoard(ownGrid);
        ShipsBoard enemyBoard = new ShipsBoard(enemyGrid);

        BattleShipPlayer player = new HumanBattleShipPlayer("J",ownBoard, enemyBoard);
        BattleShipPlayer enemyPlayer = new HumanBattleShipPlayer("Comp", enemyBoard, ownBoard);

        //player.placeShipsManualy();

        while (true){
            System.out.println(enemyBoard);
            player.shoot();
            System.out.println(enemyPlayer.answer().getBody());
        }



    }
}

