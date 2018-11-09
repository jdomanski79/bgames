package pl.jdomanski.bgames.player;

import java.util.ArrayList;
import java.util.Random;

import pl.jdomanski.bgames.Move;
import pl.jdomanski.bgames.board.GameBoard;
import pl.jdomanski.bgames.board.TicTacToeBoard;

public class RandomComputerPlayer extends Player {

	public RandomComputerPlayer(String name, String mark) {
		super(name, mark);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Move doMove(GameBoard board) {
		// TODO Auto-generated method stub
		ArrayList<Move> moves = board.getAvailableMoves();
		Random random = new Random();
				
		return moves.get(random.nextInt(moves.size()));
	}

	public static void main(String[] args) {
		GameBoard board = new TicTacToeBoard();
		
		Player rnd = new RandomComputerPlayer("R2D2", "X");
		
		System.out.println(rnd.doMove(board));
	}
}
