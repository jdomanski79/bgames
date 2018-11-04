package pl.jdomanski.tictactoe;

import java.util.ArrayList;


public class Board {

	// = fields == 
	final int  maxSize = 9;
	String[] grid = new String[maxSize];
	boolean gameWon = false;
	boolean gameTied = false;
	
	// == constructors ==
	public Board() {
		
		reset();
	}
	// == methods ==
	public void reset() {
		for (int i = 0; i < maxSize; i++) {
			grid[i] = "";
		}
		gameWon = false;
		gameTied = false;
	}
	
	public boolean isValidMove( int move) {
		if (grid[move].equals("") || move < 0 || move > maxSize -1 ) {
			return true;
		} else {
			return false;
		}
	}
	
	public void submitMove (int move, String mark) {
		grid[move] = mark;
		checkGameEnded();
	}
	
	public ArrayList getAvailableMoves(){
		ArrayList list = new ArrayList();
		for (int i = 0; i < maxSize; i++) {
			if (!grid[i].equals("")) {
				list.add(i);
			}
		}
		
		return list;
	}
	
	public boolean isGameWon() {
		return gameWon;
	}
	
	public boolean isGameTied() {
		return gameTied;
	}
	
	public boolean isGameEnded() {
		return gameWon || gameTied;
	}
	
	private void checkGameEnded() {
		if (getAvailableMoves().size() == 0) {
			gameTied = true;
		}
	}
	
	private boolean checkGameWon() {
		if (grid[0].equals(grid[1]) && grid[1].equals(grid[2]) && !grid[0].equals("") ||
			grid[3].equals(grid[4]) && grid[4].equals(grid[5]) && !grid[3].equals("") ||
			grid[6].equals(grid[7]) && grid[7].equals(grid[8]) && !grid[6].equals("") ||	
			// == columns ==
			grid[0].equals(grid[3]) && grid[3].equals(grid[6]) && !grid[0].equals("") ||
			grid[1].equals(grid[4]) && grid[4].equals(grid[7]) && !grid[1].equals("") ||
			grid[2].equals(grid[5]) && grid[5].equals(grid[8]) && !grid[2].equals("") ||
			// == diagonals ==
			grid[0].equals(grid[4]) && grid[4].equals(grid[8]) && !grid[0].equals("") ||
			grid[6].equals(grid[1]) && grid[4].equals(grid[2]) && !grid[6].equals("")
			) {
			gameWon = true;
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board board = new Board();
		String mark = "X";
		board.submitMove(0, mark);
		board.submitMove(1, mark);
		board.submitMove(2, mark);
		
		System.out.println("Game won: " + board.checkGameWon());
		

	}

}
