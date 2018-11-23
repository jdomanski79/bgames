package pl.jdomanski.bgames.ships;

import pl.jdomanski.bgames.Directions;
import pl.jdomanski.bgames.Vector;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public abstract class BattleShipPlayer {
    protected final ShipsBoard ownBoard;
    protected final ShipsBoard enemyBoard;
    // == fields ==
    protected String name;
    protected Set<Ship> fleet = new HashSet<>();

    public BattleShipPlayer(String name, ShipsBoard ownBoard, ShipsBoard enemyBoard) {
        this.name = name;
        this.ownBoard = ownBoard;
        this.enemyBoard = enemyBoard;
    }

    // == public methods ==
    public abstract void shoot();

    public String getName() {
        return name;
    }

    public abstract void placeShipsManualy();

    public boolean isLost() {
        return fleet.stream().allMatch(ship -> ship.isSunk());
    }

    public void placeShipsRandomly(){

        Random random = new Random();
        Directions randomDirection = Directions.N;
        int BOARD_WIDTH = 10;
        int BOARD_HEIGHT = 10;
        Vector firstPart = null;
        boolean placeFound = false;
        Set<Cell> cells = new HashSet<>();

        for (ShipTypes type: ShipTypes.values()){
            cells.clear();
            placeFound  = false;

            while (!placeFound) {
                randomDirection = (random.nextBoolean()) ? Directions.N : Directions.E;
                firstPart = new Vector(random.nextInt(BOARD_WIDTH - 1), random.nextInt(BOARD_HEIGHT - 1));

                if (ownBoard.numberOfPlacesForShip(firstPart, randomDirection) >= type.getSize()) {
                    placeFound = true;
                }
            }

            cells = ownBoard.getCellsForShip(firstPart,type,randomDirection);

            Ship ship = new Ship(type, cells);
            fleet.add(ship);
        }

       // System.out.println(ownBoard);
    }
}
