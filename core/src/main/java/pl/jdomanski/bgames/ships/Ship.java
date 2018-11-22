package pl.jdomanski.bgames.ships;

import java.util.*;

import pl.jdomanski.bgames.Vector;

public class Ship {

	// == fields ==
	private Set<Cell> parts;
	private boolean sunk;
	private ShipTypes type;
	
	// == constructor ==
	public Ship( ShipTypes type, Set<Cell> parts) {

	    this.parts = parts;
		this.type = type;
		this.sunk = false;

		parts.forEach(cell -> cell.setShip(this));
	}
	
	// == public methods ==
	public boolean isSunk() {
		return this.sunk;
	}

	public void hit() {

		sunk = parts.stream().allMatch(cell -> cell.isHit() );

	}
}
