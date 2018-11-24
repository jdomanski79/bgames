package pl.jdomanski.bgames;

import pl.jdomanski.bgames.ships.BattleShipPlayer;
import pl.jdomanski.bgames.ships.HumanBattleShipPlayer;
import pl.jdomanski.bgames.ships.ShipsBoard;

public class ShipsGame {

    public static void main(String[] args) {
        ShipsBoard ownBoard = new ShipsBoard();
        ShipsBoard enemyBoard = new ShipsBoard();

        BattleShipPlayer player = new HumanBattleShipPlayer("J",ownBoard, enemyBoard);
        BattleShipPlayer enemyPlayer = new HumanBattleShipPlayer("Comp", enemyBoard, ownBoard);

        player.placeShipsRandomly();
        enemyPlayer.placeShipsRandomly();
        //player.placeShipsManualy();

        while (!player.isLost()){
            System.out.println(enemyBoard);
            player.shoot();
            System.out.println(enemyPlayer.answer().getBody());
        }



    }
}

