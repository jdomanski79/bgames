package pl.jdomanski.bgames.ships;

public class Cell {
	
	// == fields ==
	private boolean empty = true;
	private boolean hitted = false;
	private Ship ship = null;
	
	// == constructors ==
	public Cell() {
		
	}
	
	public Cell(Ship ship) {
		this.empty = false;
		this.ship = ship;
	}
	
	// == public methods ==
	
	public boolean isEmpty() {
		return this.empty;
	}
	
	public boolean isShip() {
		return !this.empty;
	}

	public boolean isHitted() {
		return hitted;
	}

	public void setHitted(boolean hited) {
		this.hitted = hited;
		
		if (ship != null) {
			ship.hit();
		}
	}
	
	public boolean isMissed() {
		return !this.hitted;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.empty = false;
		this.ship = ship;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}
	
	public String toString() {
		if (empty) {
			if (hitted) {
				return "*";
			} else return " ";
		}
		else {
			if (hitted) {
				return "X";
			} else return "S";
		}
	}
	
}
