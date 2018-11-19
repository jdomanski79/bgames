package pl.jdomanski.bgames.ships;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.jdomanski.bgames.Move;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class ShipsBoardTest {

    private ShipsBoard board;

    @BeforeAll
    static void init(){
        board = new ShipsBoard();
    }
    @Test
    void isThereAvailablePlaceForShip_shouldSuccess() {
        Move move = new Move(0,0);
        int size = 2;
        boolean horizontal = false;

        assertThat(board.isThereAvailablePlaceForShip(move, size, horizontal), is(true));
    }
    @Test
    void isThereAvailablePlaceForShip_shouldFail() {
        Move move = new Move(9,9);
        int size = 2;
        boolean horizontal = false;

        assertThat(board.isThereAvailablePlaceForShip(move, size, horizontal), is(false));
    }

}