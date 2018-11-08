package pl.jdomanski.tictactoe.board;

import java.util.ArrayList;

import pl.jdomanski.tictactoe.Game;
import pl.jdomanski.tictactoe.Move;

public class Connect4Board extends GameBoard {

	// == fields ==
	
	private final int WIDTH = 4;
	
	private final int HEIGHT = 4;
	
	private final String EMPTY = " ";
	
	private String[] grid = new String[WIDTH * HEIGHT];
	
	private Move lastMove = null;
	
	// == constructor ==
	
	public Connect4Board() {
		reset();
	}
	
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
		return move.getX() >= 0 || 
			   move.getX() < WIDTH || 
			   columnNotFull( move.getX() ); 
				
	}

	@Override
	public void submitMove(Move move, String mark) {
		for (int y = 0; y < HEIGHT; y++) {
			
			int x = move.getX();
			
			if (getCell(x, y).equals(EMPTY)) {
				setCell(x, y, mark);
				lastMove = new Move(x,y);
				break;
			}
		}

	}

	

	@Override
	public void undo(Move move) {
		
		for (int y = HEIGHT - 1; y >= 0; y--) {
			int x = move.getX();
			if ( !getCell(x,y).equals(EMPTY)) {
				setCell(x,y, EMPTY);
				gameWon = false;
				gameTied = false;
				break;
			}
		}
		
	}

	@Override
	public ArrayList<Move> getAvailableMoves() {
		
		ArrayList<Move> list = new ArrayList<Move>();
		
		for (int x = 0; x < WIDTH; x++ ) {
			Move move = new Move(x);
			if (isValidMove(move)) {
				list.add(move);
			}
			//System.out.println("Possible: " + move);
		}
		
		return list;
	}

	@Override
	public boolean isGameEnded() {
		
		gameTied = getAvailableMoves().size() == 0;
			
		gameWon = checkGameWon();
		
		return this.gameWon || this.gameTied;
	}
	
	

	@Override
	public String toString() {
		String result = "";
		
		for (int y = HEIGHT - 1; y >= 0; y--) {
			result += "|";
			for (int x = 0; x < WIDTH; x++) {
				result += " " + getCell(x, y) + " |";
			}
			result += System.getProperty("line.separator"); 
		}
		
		return result;
	}
	
	// == private methods ==
	
	private boolean checkGameWon() {
		int startX = lastMove.getX();
		int startY = lastMove.getY();
		String mark = getCell(startX, startY);
		
		// == checking rows ==
		// ==     <----
		int count = 1;
		for (int x = startX - 1; x >= 0; x--) {
			if (getCell(x, startY).equals(mark)) {
				count++;
			} else 
				break;
		}
		// ==    ----->
		for (int x = startX + 1; x < WIDTH; x++) {
			if (getCell(x, startY).equals(mark)) {
				count++;
			} else 
				break;
		}
		
		if (count >= 4) return true;
		
		// == checking columns ==
		count = 1;
		// == down ==
		for (int y = startY -1; y >= 0; y--) {
			if (getCell(startX, y).equals(mark)) {
				count++;
			} else
				break;
		}
		// == up ==
		for (int y = startY + 1; y < HEIGHT; y++) {
			if (getCell(startX, y).equals(mark)) {
				count++;
			} else
				break;
		}
		
		if (count >= 4) return true;
		
		// == diagonals ==
		// === to bottom right
		count = 1 ;
		// ==== left and up
		
		int x = startX - 1;
		int y = startY + 1;
		
		while (x >= 0 && y <  HEIGHT && getCell(x,y).equals(mark)) {
			count++;
			x--;
			y++;
		}
		// ==== right and down
		
		x = startX + 1;
		y = startY - 1;
		
		while (x < WIDTH && y >= 0 && getCell(x,y).equals(mark)) {
			count++;
			x++;
			y--;
		}
		
		if (count >= 4) return true;
		
		// === to upper right
		count = 1;
		// === to left and down
		x = startX - 1;
		y = startY - 1;
		
		while (x >= 0 && y >= 0 && getCell(x,y).equals(mark)) {
			count++;
			x--;
			y--;
		}
		
		// === to right and up
		x = startX + 1;
		y = startY + 1;
		
		while (x < WIDTH && y < HEIGHT && getCell(x,y).equals(mark)) {
			count++;
			x++;
			y++;
		}
		
		if (count >= 4) return true;
		
		
		return false;
	}
	
	private void setCell(int x, int y, String mark) {
		grid[x + y * WIDTH] = mark;
	}	
	private String getLastCell(Move move) {
		
		return null;
	}
	
	private String getCell (int x, int y) {
		return grid[x + y * WIDTH];
	}
	
	private boolean columnNotFull( int column) {
		return getCell(column, HEIGHT -1).equals(EMPTY);
	}
	
	// == main == 
	public static void main(String[] args) {
		GameBoard board = new Connect4Board();
		
		board.submitMove(new Move(2), "X");
		board.submitMove(new Move(3), "X");
		board.undo(new Move(3));
		board.undo(new Move(2));
		System.out.println(board);
		System.out.println(board.isGameEnded());
		
		board.submitMove(new Move(2), "X");
		board.submitMove(new Move(2), "X");
		board.submitMove(new Move(2), "X");
		board.submitMove(new Move(2), "X");
		board.submitMove(new Move(2), "X");
		System.out.println(board);
		System.out.println(board.isGameEnded());

	}
	

}
