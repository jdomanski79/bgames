package pl.jdomanski.bgames.ships;

import java.util.ArrayList;
import java.util.Scanner;

import pl.jdomanski.bgames.Vector;
import pl.jdomanski.bgames.board.GameBoard;
import pl.jdomanski.bgames.player.Player;

public class ShipPlayer implements Player {

	// == fields == 
	private String name;
	private String mark;
	private ArrayList<Ship> fleet;

	private Scanner input = new Scanner(System.in);
	
	// == constructor ==
	public ShipPlayer(String name, String mark) {
		this.name = name;
		this.mark = mark;
	}

	// == public methods ==
	@Override
	public Vector doMove(GameBoard board) {
		System.out.println("Podaj ruch:");

		String[] in = input.nextLine().trim().toLowerCase().split("");
		// TODO validation of input

		int y = in[0].charAt(0) - 97;
		int x = Integer.valueOf(in[1]) - 1;

		return new Vector(x, y);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String getMark() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMark(String mark) {
		// TODO Auto-generated method stub

	}
	
	public void addShip(Ship ship) {
		fleet.add(ship);
	}
	
	public boolean isLost() {
		for (Ship ship: fleet) {
			if (!ship.isSunk()) {
				return false;
			}
		}
		
		return true;
	}
}
