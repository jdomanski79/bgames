package pl.jdomanski.bgames.ships;

import java.util.ArrayList;

import pl.jdomanski.bgames.Directions;
import pl.jdomanski.bgames.Vector;
import pl.jdomanski.bgames.board.GameBoard;

public class ShipsBoard extends GameBoard {
	// == fields ==
	private int WIDTH = 10;
	private int HEIGHT = 10;
	
	private Cell[] grid = new Cell[WIDTH * HEIGHT];

	public ShipsBoard() {
		reset();
	}
	
	@Override
	public void reset() {
		gameTied = false;
		gameWon = false;
		
		for (int i = 0; i < WIDTH * HEIGHT; i++) {
			grid[i] = new Cell();
		}
		
	}

	@Override
	public boolean isValidMove(Vector vector) {
		return isInBoard(vector) &&
			   !this.getCell(vector).isHit();
	}

	

	@Override
	public void submitMove(Vector vector, String mark) {
		this.getCell(vector).hit();
		
	}

	@Override
	public void undo(Vector vector) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Vector> getAvailableMoves() {
		
		ArrayList<Vector> list = new ArrayList<Vector>();
		
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				Vector vector = new Vector(x,y);
				if (!getCell(vector).isHit()) {
					list.add(vector);
				}
			}
		}
		return list;
	}

	@Override
	public boolean isGameEnded() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		String result = "";
		for (int y = HEIGHT - 1; y >= 0; y--) {
			
			for (int x = 0; x < WIDTH; x++) {
				result += "| " + getCell(new Vector(x,y)) + " ";
			}
			
			result += "\n";
		}
		return result;
	}
	
	public int numberOfPlacesForShip(Vector start, Directions direction) {
		Vector nextMove = start;
		Vector moveInDirection = direction.getVector();
		int count = 0;

		while (isInBoard(nextMove) && isValidPlaceForShipPart(nextMove)) {
		    nextMove = nextMove.plus(moveInDirection);
		    count++;
        }

        return count;
	}
	
	public void placeShip(Vector start, int size, Directions direction) {


	}
	
	// == private methods ==
	private boolean isValidPlaceForShipPart(Vector vector) {
		if (!isInBoard(vector)) return false;
	
		for (Directions direction : Directions.values()) {
			Vector neighbour = vector.plus(direction.getVector());
			
			if (isInBoard(neighbour) && !getCell(neighbour).isEmpty()) {
				return false;
			}
			
		}
		return true;
	}

	
	private Cell getCell (Vector vector) {
		return grid[vector.getX() + vector.getY() * WIDTH];
	}
	
	private boolean gameWon() {
		return false;
	}
	
	private boolean isInBoard(Vector vector) {
		return vector.getX() >= 0 && vector.getX() < WIDTH &&
				vector.getY() >= 0 && vector.getY() < HEIGHT;
	}	

}
