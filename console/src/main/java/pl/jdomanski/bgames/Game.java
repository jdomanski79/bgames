package pl.jdomanski.bgames;

import pl.jdomanski.bgames.board.Connect4Board;
import pl.jdomanski.bgames.board.GameBoard;
import pl.jdomanski.bgames.player.Player;
import pl.jdomanski.bgames.player.UnBeatableComputer;

public class Game {

	// == fields ==
	Player player1;
	Player player2;
	Player currentPlayer;
	Player otherPlayer;
	
	GameBoard board;
	
	// == constructor ==
	
	public Game(Player player1, Player player2, GameBoard board) {
		this.board   = board;
		this.player1 = player1;
		this.player2 = player2;
		this.currentPlayer = player1;
		this.otherPlayer = player2;
	}
	
	// ==  public methods ==
	public void start() {
		//System.out.println(board);
		
		while (true) {
			System.out.println(board);
			System.out.println("Kolej gracza " + currentPlayer.getName());
			Vector vector = currentPlayer.doMove(board);
			
			System.out.println("gracz wybral ruch " + vector);
			if (board.isValidMove(vector)) {
				board.submitMove(vector, currentPlayer.getMark());
			}
			//System.out.println(board);
	
			if (board.isGameEnded()) {
				System.out.println("GAME OVER!");
				if (board.isGameWon()) {
					System.out.println("Player " + currentPlayer.getName() + " won!");
				} else if (board.isGameTied()) {
					System.out.println("Game is tied");
				}
				break;
			}
			
			changeCurrentPlayer();
		}
	}
	
	// == private methods ==
	private void changeCurrentPlayer() {
		currentPlayer = (currentPlayer.equals(player1)) ? player2 : player1;
		otherPlayer = (currentPlayer.equals(player1)) ? player2 : player1;
	}
	
	// == main method ==
	
	public static void main(String[] args) {
		String[] grid = {"O", "O", "X",
						 "", "X", "0",
						 "",  "", "X"};
		
		UnBeatableComputer player1 = new UnBeatableComputer("Depth4", "X");
		player1.setMaxDepth(5);
		UnBeatableComputer player2 = new UnBeatableComputer("Depth2", "O");
		player2.setMaxDepth(5);
		
		Game game = new Game( player1, player2,new Connect4Board());
		//Game game = new Game(  new HumanPlayer("j", "X"), new RandomComputerPlayer("R2D2","O"),new Connect4Board());
		game.start();
	}
}
