package pl.jdomanski.bgames.board;

import java.util.ArrayList;

import pl.jdomanski.bgames.Move;


public class TicTacToeBoard extends GameBoard {

	// = fields == 
	private final int  maxSize = 9;
	
	private final int WIDTH = 3;
	
	private final int HEIGHT = 3;
	
	private String[] grid = new String[WIDTH * HEIGHT];
	
	
	// == constructors ==
	public TicTacToeBoard() {
		
		reset();
	}
	
	public TicTacToeBoard(String[] grid) {
		this.grid = grid;
	}
	// == methods ==
	/* (non-Javadoc)
	 * @see pl.jdomanski.tictactoe.GameBoard#reset()
	 */
	public void reset() {
		for (int i = 0; i < maxSize; i++) {
			grid[i] = "";
		}
		gameWon = false;
		gameTied = false;
	}
	
	/* (non-Javadoc)
	 * @see pl.jdomanski.tictactoe.GameBoard#isValidMove(int)
	 */
	public boolean isValidMove(Move move) {
		if (move.getY() == null) {
			if (move.getX() < 0 || move.getX() > WIDTH * HEIGHT) 
				return false;
		}
		
		if (move.getY() != null) { 
			if (move.getY() < 0 || move.getY() >= HEIGHT ||
				move.getX() < 0 || move.getX() >= WIDTH)
				return false;
		}
		
		if (!getCell(move).equals("")) {
			return false;
		} 
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see pl.jdomanski.tictactoe.GameBoard#submitMove(int, java.lang.String)
	 */
	public void submitMove (Move move, String mark) {
		setCell(move, mark);
	}
	
	public void undo(Move move) {
		setCell(move, "");
		gameWon = false;
		gameTied = false;
		
	}

	
	/* (non-Javadoc)
	 * @see pl.jdomanski.tictactoe.GameBoard#getAvailableMoves()
	 */
	public ArrayList<Move> getAvailableMoves(){
		ArrayList<Move> list = new ArrayList();
		for (int i = 0; i < maxSize; i++) {
			if (grid[i].equals("")) {
				list.add(new Move(i));
			}
		}
		
		return list;
	}
	
	/* (non-Javadoc)
	 * @see pl.jdomanski.tictactoe.GameBoard#isGameWon()
	 */
	public boolean isGameWon() {
		return gameWon;
	}
	
	/* (non-Javadoc)
	 * @see pl.jdomanski.tictactoe.GameBoard#isGameTied()
	 */
	public boolean isGameTied() {
		return gameTied;
	}
	
	/* (non-Javadoc)
	 * @see pl.jdomanski.tictactoe.GameBoard#isGameEnded()
	 */
	public boolean isGameEnded() {
		
		if (getAvailableMoves().size() == 0) {
			gameTied = true;
		} else if (checkGameWon()) {
			gameWon = true;
		}
		return gameWon || gameTied;
	}
	
	public String toString() {
		String result = "";
		for (int y = 0; y < HEIGHT; y++) {
			result += "|";
			for (int x = 0; x < WIDTH; x++) {
				if (getCell(x,y).equals("")) {
					result += "   |";
				} else {
					result += " " + getCell(x,y) + " |";
				}
			}
			result += System.getProperty("line.separator");
		}
		
		return result;
	}
	
	// == private methods ==
	private String getCell(Move move) {
		int value = move.getX();
		
		if (move.getY() != null) {
			value = value + move.getY() * WIDTH; 
		}
		
		return grid[value];
	}
	
	private String getCell(int x, int y) {
		return grid[x + y * WIDTH];
	}
	
	
	private void setCell(Move move, String mark) {
		int value = move.getX();
		
		if (move.getY() != null) {
			value = value + move.getY() * WIDTH;
		}
		
		grid[value] = mark;
	}
	
	private void checkGameEnded() {
		if (getAvailableMoves().size() == 0) {
			gameTied = true;
		} else if (checkGameWon()) {
			gameWon = true;
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
			grid[6].equals(grid[4]) && grid[4].equals(grid[2]) && !grid[6].equals("")
			) {
			return true;
		}
		
		return false;
	}
	
	// == main method ==
	
	public static void main(String[] args) {
		TicTacToeBoard board = new TicTacToeBoard();
		String mark = "X";
		board.submitMove(new Move(3), mark);
		board.submitMove(new Move(4), mark);
		board.submitMove(new Move(5), mark);
		
		System.out.println(board);
		System.out.println("Game won: " + board.checkGameWon());
		

	}
	
}
