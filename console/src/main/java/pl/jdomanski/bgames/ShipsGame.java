package pl.jdomanski.bgames;

import pl.jdomanski.bgames.ships.ShipPlayer;
import pl.jdomanski.bgames.ships.ShipsBoard;

public class ShipsGame {

    public static void main(String[] args) {
        ShipsBoard player1board = new ShipsBoard();
        ShipsBoard player2board = new ShipsBoard();
        
        ShipPlayer player1 = new ShipPlayer();
        ShipPlayer player2 = new ShipPlayer();
        
        player1.setOwnBoard(player1board);
        player1.setEnemyBoard(player2board);
        
        player2.setOwnBoard(player2board);
        player2.setEnemyBoard(player1board);

        

    }
}

