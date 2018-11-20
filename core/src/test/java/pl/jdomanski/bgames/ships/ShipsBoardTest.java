package pl.jdomanski.bgames.ships;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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
        Move move = new Move(0,0);
        int size = 2;
        boolean horizontal = false;

        assertThat(board.isThereAvailablePlaceForShip(move, size, horizontal), is(true));
    }
    @Testst
    void isThereAvailablePlaceForShip_shouldFail() {
        Move move = new Move(9,9);
        int size = 2;
        boolean horizontal = false;

        assertThat(board.isThereAvailablePlaceForShip(move, size, horizontal), is(false));
    }

    @Test
    void placeShip(){
        Move start = new Move(0,0);
        int size = 3;
        boolean horizontal = true;

        board.placeShip(start, size, horizontal);
//        assertThat("Is ship.", board.get);
    }
}