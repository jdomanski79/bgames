package pl.jdomanski.bgames.ships;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.jdomanski.bgames.Directions;
import pl.jdomanski.bgames.Move;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class ShipsBoardTest {

    static ShipsBoard board;

    @BeforeAll
    static void init(){
        board = new ShipsBoard();
    }

    @Test
    void isThereAvailablePlaceForShip_shouldSuccess() {
        Move move = new Move(0,1);
        int size = 2;
        Directions dir = Directions.N;

        assertThat(board.numberOfPlacesForShip(move, dir), is(9));
    }
}