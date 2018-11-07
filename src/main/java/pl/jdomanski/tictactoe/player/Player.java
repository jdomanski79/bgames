package pl.jdomanski.tictactoe.player;

import pl.jdomanski.tictactoe.Move;
import pl.jdomanski.tictactoe.board.GameBoard;

public abstract class Player {

	// == fields ==
	protected String name;
	protected void name() {
		
	} String mark;
	
	// == constructor ==
	public Player(String name, String mark) {
		this.name = name;
		this.mark = mark;
	}
	
	public abstract Move doMove(GameBoard board);

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
	
}
