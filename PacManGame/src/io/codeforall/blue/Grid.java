package io.codeforall.blue;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    public static final int PADDING = 10;

    private int cellSize = 30;
    private int cols;
    private int rows;

    private Rectangle field;

    /**
     * Simple graphics grid constructor with a certain number of rows and columns
     *
     * @param cols number of the columns
     * @param rows number of rows
     */
    public Grid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }

    /**
     * Initializes the field simple graphics rectangle and draws it
     */

    public void init() {
        this.field = new Rectangle(PADDING,PADDING, cols * cellSize, rows * cellSize);
        this.field.draw();
    }

    public int getCellSize() {
        return cellSize;
    }


    public int getCols() {
        return this.cols;
    }


    public int getRows() {
        return this.rows;
    }

    public int getWidth() {
        return this.field.getWidth();
    }

    public int getHeight() {
        return this.field.getHeight();
    }

    public int getX() {
        return this.field.getX();
    }

    public int getY() {
        return this.field.getY();
    }

    /**
     * @see Grid#makeGridPosition()
     */

    public GridPosition makeGridPosition() {
        return new GraphicsGridPosition(this);
    }

    /**
     * @see Grid#makeGridPosition(int, int)
     */

    public GridPosition makeGridPosition(int col, int row) {
        return new GraphicsGridPosition(col, row, this);
    }

    /**
     * Auxiliary method to compute the y value that corresponds to a specific row
     * @param row index
     * @return y pixel value
     */
    public int rowToY(int row) {
        return PADDING + cellSize * row;
    }

    /**
     * Auxiliary method to compute the x value that corresponds to a specific column
     * @param column index
     * @return x pixel value
     */
    public int columnToX(int column) {
        return PADDING + cellSize * column;
    }

}

