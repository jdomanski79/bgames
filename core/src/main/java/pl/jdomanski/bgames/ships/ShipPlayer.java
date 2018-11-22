package pl.jdomanski.bgames.ships;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import pl.jdomanski.bgames.Directions;
import pl.jdomanski.bgames.Vector;
import pl.jdomanski.bgames.board.GameBoard;
import pl.jdomanski.bgames.player.Player;

public class ShipPlayer {


	// == fields ==
	private String name;
	private final ShipsBoard board;
	private Set<Ship> fleet = new HashSet<>();

	private Scanner input = new Scanner(System.in);
	
	// == constructor ==
	public ShipPlayer(String name, ShipsBoard board) {
		this.board = board;
		this.name = name;
	}

	// == public methods ==
	public Vector doMove() {
		System.out.println("Podaj ruch:");

		String[] in = input.nextLine().trim().toLowerCase().split("");
		// TODO validation of input

		int y = in[0].charAt(0) - 97;
		int x = Integer.valueOf(in[1]) - 1;

		return new Vector(x, y);
	}

	public String getName() {
		return name;
	}

	public void placeShipsManualy(){
		System.out.println("Podaj pozycje statków:");
		for (ShipTypes type: ShipTypes.values()){
			System.out.println("Podaj pozycję statku " + type.getName() + ".");
			System.out.println("Długość statku to: " + type.getSize());

			String in = input.nextLine().trim().toLowerCase();

			int y  = in.substring(0,1).charAt(0) - 'a';
			int x = Integer.valueOf(in.substring(1)) - 1;

			Vector shipFirstPart = new Vector(x,y);
			Set<Cell> cells = new HashSet<>();

			cells = board.getCellsForShip(shipFirstPart, type, Directions.N);

			Ship ship = new Ship(type, cells);
			fleet.add(ship);
			System.out.println(board);

		}
	}
	public void addShip(Ship ship) {
		fleet.add(ship);
	}
	
	public boolean isLost() {
	    return fleet.stream().allMatch(ship -> ship.isSunk());
	}
}
