package pl.jdomanski.bgames.ships;

import java.util.ArrayList;
import java.util.Map;

import pl.jdomanski.bgames.Move;
import pl.jdomanski.bgames.board.GameBoard;
import pl.jdomanski.bgames.player.Player;

public class Ship {

	// == fields ==
	private Player owner;
	private Map<Move, Cell> parts;
	private boolean sunk;
	
	// == constructor ==
	public Ship(ArrayList<Move> moves, Player player, GameBoard board) {
		
		for (Move move : moves) {
			Cell cell = new Cell(this);
			parts.put(move, cell);
		}
		
		this.sunk = false;
		this.owner = player;
	}
	
	// == public methods ==
	public boolean isSunk() {
		return this.sunk;
	}
	public void hit() {
		
		for (Move move: parts.keySet()) {
			if (parts.get(move).isMissed()) {
				sunk = false;
				break;
			}
		}
		sunk = true;
	}
}
