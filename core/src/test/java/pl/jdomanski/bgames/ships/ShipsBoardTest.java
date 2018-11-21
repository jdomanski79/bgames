package pl.jdomanski.bgames.ships;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.jdomanski.bgames.Directions;
import pl.jdomanski.bgames.Move;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@Disabled
class ShipsBoardTest {

    static ShipsBoard board;

    @BeforeAll
    static void init(){
        board = new ShipsBoard();
    }

}
