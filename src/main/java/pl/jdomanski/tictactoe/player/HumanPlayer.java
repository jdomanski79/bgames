package pl.jdomanski.tictactoe.player;

import java.util.Scanner;

import pl.jdomanski.tictactoe.Move;
import pl.jdomanski.tictactoe.board.TicTacToeBoard;
import pl.jdomanski.tictactoe.board.GameBoard;

public class HumanPlayer extends Player {

	// == fields ==
	private Scanner input = new Scanner(System.in);
	
	// == constructor ==
	public HumanPlayer(String name, String mark) {
		super(name, mark);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Move doMove(GameBoard board) {
		// TODO Auto-generated method stub
		System.out.println("Podaj ruch (x,y): ");
		
		String[] in = input.nextLine().trim().split(",");
		
		return new Move(Integer.valueOf(in[0]), Integer.valueOf(in[1]));
	}
	
	// main method
	
	public static void main(String[] args) {
		Player player = new HumanPlayer("J", "X");
		TicTacToeBoard board = new TicTacToeBoard();
		
		System.out.println(player.doMove(board));
	}

}