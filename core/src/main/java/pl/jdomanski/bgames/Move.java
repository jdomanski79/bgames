package pl.jdomanski.bgames;

public class Move {

	// == fields ==
	private Integer x;
	private Integer y;
	
	// == constructors ==
	public Move (int x) {
		this.x = x;
	}
	
	

	public Move( int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// == public methods ==
	public Integer getX() {
		return x;
	}

	public Integer getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Move [x=" + x + ", y=" + y + "]";
	}

}
