package pl.jdomanski.bgames.ships;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class ShipTest {

    @Test
    void isSunk() {
        Ship ship = new Ship(ShipTypes.BATTLESHIP);

        Cell part1 = new Cell();
        Cell part2 = new Cell();
        Cell part3 = new Cell();
        part1.setShip(ship);
        part2.setShip(ship);
        part3.setShip(ship);
        ship.addShipPart(part1);
        ship.addShipPart(part2);
        ship.addShipPart(part3);

        assertThat(ship.isSunk()).as("The ship is new!", ship.isSunk()).isFalse();

        part1.hit();
        assertThat(part1.isHit()).isTrue();
        assertThat(ship.isSunk()).as("The ship is not sunk, 1/3 part hit.", ship.isSunk()).isFalse();

        part2.hit();

        assertThat(ship.isSunk()).as("The ship is not sunk, 2/3 parts hit", ship.isSunk()).isFalse();

        part3.hit();

        assertThat(ship.isSunk()).isTrue();


    }


    @Test
    void hit() {
    }
}