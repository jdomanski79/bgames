package pl.jdomanski.tictactoe.board;

import java.util.ArrayList;

import pl.jdomanski.tictactoe.Move;

public class Connect4Board extends GameBoard {

	// == fields ==
	
	private final int WIDTH = 6;
	
	private final int HEIGHT = 8;
	
	private final String EMPTY = " ";
	
	private String[] grid = new String[WIDTH * HEIGHT];
	
	@Override
	public void reset() {
		for (int i = 0; i < WIDTH * HEIGHT; i++) {
			grid[i] = EMPTY;
		}
		
		gameTied = false;
		gameWon = false;
	}

	@Override
	public boolean isValidMove(Move move) {
		return move.getX() < 0 || 
			   move.getX() >= WIDTH || 
			   columnFull( move.getX()); 
				
	}

	@Override
	public void submitMove(Move move, String mark) {
		for (int y = 0; y < HEIGHT; y++) {
			
			int x = move.getX();
			
			if (getCell(x, y).equals(EMPTY)) {
				setCell(x, y, mark);
			}
		}
		
	}

	

	@Override
	public void undo(Move move) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Move> getAvailableMoves() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isGameEnded() {
		// TODO Auto-generated method stub
		return false;
	}
	
	// == private methdods ==
	
	private void setCell(int x, int y, String mark) {
		grid[x + y * HEIGHT] = mark;
	}	
	private String getLastCell(Move move) {
		
		return null;
	}
	
	private String getCell (int x, int y) {
		return grid[x + y * HEIGHT];
	}
	
	private boolean columnFull( int column) {
		return !getCell(column, HEIGHT -1).equals(EMPTY);
	}

}
