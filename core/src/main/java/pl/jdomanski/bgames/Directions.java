package pl.jdomanski.bgames;

public enum Directions {
	N (new Move( 0, 1)),
	NE(new Move( 1, 1)),
	E (new Move( 1, 0)),
	SE(new Move( 1,-1)),
	S (new Move( 0,-1)),
	SW(new Move(-1,-1)),
	W (new Move(-1, 0)),
	NW(new Move(-1, 1)),
	;
	
	private Move move;
	
	Directions(Move move) {
		this.move = move;
	}
	
	public Move getMove() {
		return this.move;
	}
}
