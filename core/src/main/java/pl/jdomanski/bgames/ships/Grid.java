package pl.jdomanski.bgames.ships;

import pl.jdomanski.bgames.Vector;

public class Grid {
    private Cell[] grid;
    public final int HEIGHT;
    public final int WIDTH;

    public Grid(int width, int height) {
        this.HEIGHT = height;
        this.WIDTH = width;
        this.grid = new Cell[width * height];
    }

    public Cell getCell(Vector vector){
        return grid[vector.getX() + vector.getY() * WIDTH];
    }

    public boolean isInside(Vector v){
        return (v.getX() >= 0 && v.getX() < WIDTH &&
                v.getY() >= 0 && v.getY() < HEIGHT);
    }
}
