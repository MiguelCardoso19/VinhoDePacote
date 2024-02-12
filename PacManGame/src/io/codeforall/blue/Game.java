package io.codeforall.blue;

public class Game {
    private Grid grid;

    //private int delay;

    private PacMan pacMan;

    public Game(int cols, int rows/*, int delay*/) {
        grid = new Grid(cols, rows);
        grid.makeGridPosition(cols, rows);
        //this.delay = delay;
    }

    public void init() {

        grid.init();

        pacMan = new PacMan(grid.makeGridPosition(Grid.PADDING, Grid.PADDING));
        while (true) {
            //Thread.sleep(delay);
            System.out.println(pacMan.getPos());
        }
    }
}
