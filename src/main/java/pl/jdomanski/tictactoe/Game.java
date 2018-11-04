package pl.jdomanski.tictactoe;

public class Game {

	// == fields ==
	Player player1;
	Player player2;
	Player currentPlayer;
	
	Board board;
	
	// == constructor ==
	
	public Game(Player player1, Player player2, Board board) {
		this.board   = board;
		this.player1 = player1;
		this.player2 = player2;
		this.currentPlayer = player1;
	}
	
	// ==  public methods ==
	public void start() {
		
		while (true) {
			int move = currentPlayer.move(board);
			
			if (board.isValidMove(move)) {
				board.submitMove(move, currentPlayer.getMark());
			}
			
			if (board.isGameEnded()) {
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
	}
}
