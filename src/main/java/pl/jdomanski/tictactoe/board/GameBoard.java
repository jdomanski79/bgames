package pl.jdomanski.tictactoe.board;

import java.util.ArrayList;

import pl.jdomanski.tictactoe.Move;

public abstract class GameBoard {
	// == fields ==
	protected boolean gameWon = false;
	
	protected boolean gameTied = false;
	
	// == constructor ==
//	public GameBoard() {
//		reset();
//	}
	
	// == abstract methods ==
	abstract public void reset();

	abstract public boolean isValidMove(Move move);

	abstract public void submitMove(Move move, String mark);
	
	abstract public void undo(Move move);

	abstract public ArrayList<Move> getAvailableMoves();

	abstract public boolean isGameEnded();
	
	abstract public String toString();
	
	// == methods ==
	public boolean isGameWon() {
		return gameWon;
	}

	public boolean isGameTied() {
		return gameTied;
	}

	

}