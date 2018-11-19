package pl.jdomanski.bgames.player;

import java.util.ArrayList;
import java.util.Random;

import pl.jdomanski.bgames.Move;
import pl.jdomanski.bgames.board.GameBoard;
import pl.jdomanski.bgames.board.TicTacToeBoard;

public class RandomComputerPlayer implements Player {
	
	// == fields ==
	private String name;
	private String mark;
	
	public RandomComputerPlayer(String name, String mark) {
		this.name = name;
		this.mark = mark;
	}

	@Override
	public Move doMove(GameBoard board) {
		ArrayList<Move> moves = board.getAvailableMoves();
		Random random = new Random();
				
		return moves.get(random.nextInt(moves.size()));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public static void main(String[] args) {
		GameBoard board = new TicTacToeBoard();
		
		Player rnd = new RandomComputerPlayer("R2D2", "X");
		
		System.out.println(rnd.doMove(board));
	}
}
