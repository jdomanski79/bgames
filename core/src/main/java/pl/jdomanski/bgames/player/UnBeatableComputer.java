package pl.jdomanski.bgames.player;

import java.util.ArrayList;
import java.util.Random;

import pl.jdomanski.bgames.Move;
import pl.jdomanski.bgames.board.GameBoard;

public class UnBeatableComputer extends Player {

	// == fields ==
	
	private String oponnent;
	private int maxDepth = 6;
	
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
	
	public void setMaxDepth(int depth) {
		this.maxDepth = depth;
	}
	// == private methdos ==
	
	private Move bestMove(GameBoard board) {
		Move bestMove = null;
		ArrayList<Move> bestMoves = new ArrayList<Move>();
 		int bestMoveValue = Integer.MIN_VALUE;
		
		for (Move move : board.getAvailableMoves() ) {
			
			board.submitMove(move, mark);
			//System.out.println("testing move START" + move);
			//System.out.println(board);
			int moveValue = minmax( board,0, false);
			//System.out.println("Main move " + move + " value: " + moveValue);
			//System.out.println(board);
			//System.out.println("------------------------------------");
			board.undo(move);
			
			if (moveValue > bestMoveValue) {
				bestMoves.clear();
				bestMoves.add(move);
				bestMoveValue = moveValue;
			} else if (moveValue == bestMoveValue) {
				bestMoves.add(move);
			}
		}
		//System.out.println("board after minmax: ");
		//System.out.println(board);
		Random rnd = new Random();
		bestMove = bestMoves.get(rnd.nextInt(bestMoves.size()));
		
		return bestMove;
	}
	
	private int minmax(GameBoard board, int depth, boolean isMaximazingPlayer) {
		//System.out.println("minmax board");
		//System.out.println(board);
		if (depth > maxDepth) {
			//System.out.println("to deep..");
			return 0;
		}
		if (board.isGameEnded()) {
			int val = 0; // tied
			
			if (board.isGameWon()) {
				val = (isMaximazingPlayer) ? -10 : 10;
			}
			return val;
		}
		int bestVal;
		String result = "";
		for (int i = 0; i<=depth; i++ ) {
			result += "   ";
		}
		if (isMaximazingPlayer) {
			bestVal = Integer.MIN_VALUE;
			for (Move move: board.getAvailableMoves()) {
				board.submitMove(move, mark);
				//System.out.println(result + "submit " + move + " " + depth);
				int val = minmax(board, depth + 1, false);
				bestVal = Math.max(val, bestVal);
				
//				if (depth == 1) {
//					System.out.println("       move max " + move + bestVal);
//				}
				//System.out.println(result + "undo   " + move + " " + depth);
				board.undo(move);
			}
		} else {
			bestVal = Integer.MAX_VALUE;
			for (Move move: board.getAvailableMoves()) {
				board.submitMove(move, oponnent);
				//System.out.println(result + "submit " + move + " " + depth);

				int val = minmax(board, depth + 1, true);
				bestVal = Math.min(val, bestVal);
				
//				if (depth == 1) {
//					System.out.println("       move min" + move + bestVal);
//				}
				//System.out.println(result + "undo   " + move + " " + depth);

				board.undo(move);
			}
			
		}
		//System.out.println("-----");
		return bestVal;
	}
	
	// == main method ==

}
