package pl.jdomanski.bgames.player;

import pl.jdomanski.bgames.Move;
import pl.jdomanski.bgames.board.GameBoard;

public interface Player {

	public Move doMove(GameBoard board);

	public String getName();

	public void setName(String name);

	public String getMark(); 

	public void setMark(String mark);
	
}
