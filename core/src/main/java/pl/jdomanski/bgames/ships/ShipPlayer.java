package pl.jdomanski.bgames.ships;

import java.util.ArrayList;

import pl.jdomanski.bgames.Vector;
import pl.jdomanski.bgames.board.GameBoard;
import pl.jdomanski.bgames.player.Player;

public class ShipPlayer implements Player {

	// == fields ==
	private String name;
	private String mark;
	private ShipsBoard ownBoard;
	private ShipsBoard enemyBoard;

	// == constructor ==
	public ShipPlayer() {
		this.name = "RandomPlayer";
		this.mark = "S";
	}

	public ShipPlayer(String name, String mark) {
		this.name = name;
		this.mark = mark;
	}

	// == public methods ==
	@Override
	public Vector doMove(GameBoard board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getMark() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMark(String mark) {
		// TODO Auto-generated method stub

	}

	public boolean isLost() {
		return ownBoard.getFleet().stream().allMatch(ship -> ship.isSunk());
	}

	public ShipsBoard getOwnBoard() {
		return ownBoard;
	}

	public void setOwnBoard(ShipsBoard ownBoard) {
		this.ownBoard = ownBoard;
	}

	public ShipsBoard getEnemyBoard() {
		return enemyBoard;
	}

	public void setEnemyBoard(ShipsBoard enemyBoard) {
		this.enemyBoard = enemyBoard;
	}
}
