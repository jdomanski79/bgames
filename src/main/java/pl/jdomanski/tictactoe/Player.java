package pl.jdomanski.tictactoe;


public abstract class Player {

	// == fields ==
	private String name;
	private String mark;
	
	// == constructor ==
	public Player(String name, String mark) {
		this.name = name;
		this.mark = mark;
	}

	
	abstract int move(Board board);

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
