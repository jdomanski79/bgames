package pl.jdomanski.tictactoe.player;

import pl.jdomanski.tictactoe.Move;
import pl.jdomanski.tictactoe.board.GameBoard;

public class UnBeatableComputer extends Player {

	// == fields ==
	
	String oponnent;
	
	// == constructor ==
	public UnBeatableComputer(String name, String mark) {
		super(name, mark);
		oponnent = (mark.equals("X")) ? "O" : "X";
	}

	@Override
	public Move doMove(GameBoard board) {
		// TODO Auto-generated method stub
		return bestMove(board);
	}
	
	// == private methdos ==
	
	private Move bestMove(GameBoard board) {
		Move bestMove = null;
		int bestMoveValue = Integer.MIN_VALUE;
		
		for (Move move : board.getAvailableMoves() ) {
			board.submitMove(move, mark);
			
			int moveValue = minmax( board,1, false);
			System.out.println("Main move " + move + " value: " + moveValue);
			
			board.undo(move);
			
			if (moveValue > bestMoveValue) {
				bestMove = move;
				bestMoveValue = moveValue;
			}
		}
		
		return bestMove;
	}
	
	private int minmax(GameBoard board, int depth, boolean isMaximazingPlayer) {
		
		if (board.isGameEnded()) {
			int val = 0; // tied
			
			if (board.isGameWon()) {
				val = (isMaximazingPlayer) ? -10 : 10;
			}
			return val;
		}
		
		if (isMaximazingPlayer) {
			int bestVal = Integer.MIN_VALUE;
			for (Move move: board.getAvailableMoves()) {
				board.submitMove(move, mark);
				
				int val = minmax(board, depth + 1, false);
				bestVal = Math.max(val, bestVal);
				
//				if (depth == 1) {
//					System.out.println("       move max " + move + bestVal);
//				}
				board.undo(move);
			}
			return bestVal;
		} else {
			int bestVal = Integer.MAX_VALUE;
			for (Move move: board.getAvailableMoves()) {
				board.submitMove(move, oponnent);
				
				int val = minmax(board, depth + 1, true);
				bestVal = Math.min(val, bestVal);
				
//				if (depth == 1) {
//					System.out.println("       move min" + move + bestVal);
//				}
				board.undo(move);
			}
			return bestVal;
		}
		
	}
	
	// == main method ==

}
