package pl.jdomanski.bgames.player;

import java.util.Scanner;

import pl.jdomanski.bgames.Move;
import pl.jdomanski.bgames.board.Connect4Board;
import pl.jdomanski.bgames.board.GameBoard;
import pl.jdomanski.bgames.board.TicTacToeBoard;

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
		
		if (board instanceof TicTacToeBoard) {
			System.out.println("Podaj ruch (x,y): ");
				
			String[] in = input.nextLine().trim().split(",");
		
			return new Move(Integer.valueOf(in[0]), Integer.valueOf(in[1]));
		} else if (board instanceof Connect4Board) {
			System.out.println("Podaj ruch (x): ");
			
			String in = input.nextLine().trim();
		
			return new Move(Integer.valueOf(in));
		}
		
		return null;
	}
	
	// main method
	
	public static void main(String[] args) {
		Player player = new HumanPlayer("J", "X");
		TicTacToeBoard board = new TicTacToeBoard();
		
		System.out.println(player.doMove(board));
	}

}
