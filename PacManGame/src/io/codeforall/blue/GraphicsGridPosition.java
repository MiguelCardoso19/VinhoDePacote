package io.codeforall.blue;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GraphicsGridPosition extends AbstractGridPosition{

    private Picture pacMan;
    private Grid grid;

    /**
     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */
    public GraphicsGridPosition(Grid grid){
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);

        this.grid = grid;

        int x = grid.columnToX(getCol());
        int y = grid.rowToY(getRow());

        //this.pacMan = new PacMan(grid.makeGridPosition());

        show();
    }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public GraphicsGridPosition(int col, int row, Grid grid){
        super(col, row, grid);

        this.grid = grid;

        int x = grid.columnToX(col);
        int y = grid.rowToY(row);

        this.pacMan = new Picture(x, y,"Resources/PacManRight.png");

        show();
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        this.pacMan.draw();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        this.pacMan.delete();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {

        int initialCol = getCol();
        int initialRow = getRow();

        super.moveInDirection(direction, distance);

        int dx = grid.columnToX(getCol()) - grid.columnToX(initialCol);
        int dy = grid.rowToY(getRow()) - grid.rowToY(initialRow);

        this.pacMan.translate(dx,dy);

    }

}
