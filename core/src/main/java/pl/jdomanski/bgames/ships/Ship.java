package pl.jdomanski.bgames.ships;

import java.util.*;

import pl.jdomanski.bgames.Vector;

public class Ship {

	// == fields ==
	private Set<Cell> parts;
	private boolean sunk;
	private ShipTypes type;
	
	// == constructor ==
	public Ship( ShipTypes type ) {

	    this.parts = new HashSet<>();
		this.type = type;
		this.sunk = false;
	}
	
	// == public methods ==
	public boolean isSunk() {
		return this.sunk;
	}

	public void addShipPart(Cell part){
		parts.add(part);
	}

	public void hit() {

		boolean allPartsHit = parts.stream().allMatch(cell -> cell.isHit() == true);

		sunk = allPartsHit;
	}
}
