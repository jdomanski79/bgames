package pl.jdomanski.bgames.ships;

public enum Fleet {
    CARRIER(5),
    BATTLESHIP(4),
    CRUISER(3),
    SUBMARINE(3),
    DESTROYER(2);

    // == fields ==
    private int size;

    public int getSize() {
        return size;
    }

    Fleet(int size) {
        this.size = size;
    }


}
