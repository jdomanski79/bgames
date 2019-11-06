package pl.jdomanski.bgames.ships;

import java.util.ArrayList;
import java.util.Map;

import pl.jdomanski.bgames.Vector;

public class Ship {

	// == fields ==
	private Map<Vector, Cell> parts;
	private boolean sunk;
	private ShipTypes type;
	
	// == constructor ==
	public Ship(ArrayList<Vector> vectors, ShipTypes type ) {
		
		for (Vector vector : vectors) {
			Cell cell = new Cell(this);
			parts.put(vector, cell);
		}
		this.type = type;
		this.sunk = false;
	}
	
	// == public methods ==
	public boolean isSunk() {
		return this.sunk;
	}
	public void hit() {
		
		for (Vector vector : parts.keySet()) {
			if (parts.get(vector).isNotHitted()) {
				sunk = false;
				break;
			}
		}
		sunk = true;
	}
}
