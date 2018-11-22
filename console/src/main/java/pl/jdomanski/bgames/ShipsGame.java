package pl.jdomanski.bgames;

import pl.jdomanski.bgames.ships.ShipPlayer;
import pl.jdomanski.bgames.ships.ShipsBoard;

public class ShipsGame {

    public static void main(String[] args) {
        ShipsBoard board = new ShipsBoard();
        ShipPlayer player = new ShipPlayer("J",board);
        player.placeShipsManualy();

        while (true){
            System.out.println(board);
            board.submitMove(player.doMove());
        }



    }
}

