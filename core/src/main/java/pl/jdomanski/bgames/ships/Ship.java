package pl.jdomanski.bgames.ships;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.jdomanski.bgames.Vector;

public class Ship {

	// == fields ==
	private final Logger log = LoggerFactory.getLogger(Ship.class);
	private Set<Cell> parts;
	private boolean sunk;
	private ShipTypes type;
	
	// == constructor ==
	public Ship( ShipTypes type, Set<Cell> parts) {

	    this.parts = parts;
		this.type = type;
		this.sunk = false;

		log.info("Ship {} created. Parts: {}", this, this.parts);

		this.parts.forEach(cell -> {
			cell.setShip(this);
			log.info("Cell for ship {}", cell.hashCode());
		});
	}
	
	// == public methods ==
	public boolean isSunk() {
		return this.sunk;
	}

	public void hit() {
		log.info("hit ship -> {}", this);
		log.info("parts {}", parts);
		sunk = parts.stream().allMatch(cell -> {
			log.info("Cell hash {} hit? {}", cell.hashCode(), cell.isHit());
			return cell.isHit();
		} );
	}
}
