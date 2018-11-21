package pl.jdomanski.bgames.ships;

import java.util.ArrayList;

import pl.jdomanski.bgames.Directions;
import pl.jdomanski.bgames.Move;
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
	public boolean isValidMove(Move move) {
		return isInBoard(move) &&
			   !this.getCell(move).isHitted();
	}

	

	@Override
	public void submitMove(Move move, String mark) {
		this.getCell(move).setHitted(true);
		
	}

	@Override
	public void undo(Move move) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Move> getAvailableMoves() {
		
		ArrayList<Move> list = new ArrayList<Move>();
		
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				Move move = new Move(x,y);
				if (!getCell(move).isHitted()) {
					list.add(move);
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
				result += "| " + getCell(new Move(x,y)) + " ";
			}
			
			result += "\n";
		}
		return result;
	}
	
	public boolean isThereAvailablePlaceForShip(Move start, int size, Directions direction) {
		Move nextMove = start;

		for (int i = 0; i < size; i++){

            if (!(isInBoard(nextMove) || isValidPlaceForShipPart(nextMove))) {
                return false;
            }

			nextMove = nextMove.plus(direction.getMove());
		}

		return true;
		
	}
	
	public void placeShip(Move start, int size, boolean horizontal) {
		
	}
	
	// == private methods ==
	private boolean isValidPlaceForShipPart(Move move) {
		if (!isInBoard(move)) return false;
		
		for (Directions direction : Directions.values()) {
			Move neighbour = move.plus(direction.getMove());
			
			if (isInBoard(neighbour) && !getCell(neighbour).isEmpty()) {
				return false;
			}
			
		}
		return true;
	}

	
	private Cell getCell (Move move) {
		return grid[move.getX() + move.getY() * WIDTH];
	}
	
	private boolean gameWon() {
		return false;
	}
	
	private boolean isInBoard(Move move) {
		return move.getX() >= 0 && move.getX() < WIDTH &&
				move.getY() >= 0 && move.getY() < HEIGHT;
	}	
	// == main method ==

}
