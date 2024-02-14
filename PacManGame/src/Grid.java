import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {
    private int beginningX;
    private int beginningY;
    private int width;
    private int height;
    private int cellSize;

    private String[][] maze = {
            {"0", "1", "1", "2", "0", "1", "1", "1", "1", "1", "2", "0", "1", "1", "0"},
            {"2", "0", "0", "2", "0", "0", "0", "0", "0", "0", "2", "0", "0", "2", "0"},
            {"2", "0", "0", "0", "0", "1", "1", "0", "1", "1", "0", "0", "0", "2", "0"},
            {"2", "0", "1", "1", "2", "0", "0", "0", "0", "2", "0", "1", "1", "2", "0"},
            {"0", "0", "1", "1", "2", "1", "1", "1", "1", "3", "0", "1", "1", "0", "0"},
            {"2", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "2", "0"},
            {"2", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "2", "0"},
            {"2", "1", "1", "2", "0", "1", "1", "1", "1", "1", "2", "0", "1", "3", "0"},
            {"0", "0", "0", "2", "0", "0", "0", "0", "0", "0", "2", "0", "0", "0", "P"}
    };

    public Grid(int beginningX, int beginningY) {
        this.width = maze[0].length;
        this.height = maze.length;
        this.cellSize = 50;

        Rectangle grid = new Rectangle(beginningX, beginningY, width * cellSize, height * cellSize);
        grid.setColor(Color.BLACK);
        grid.fill();

        this.beginningX = beginningX;
        this.beginningY = beginningY;

        this.drawMaze();
    }

    public int getBeginningX() {
        return beginningX;
    }

    public int getBeginningY() {
        return beginningY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getCellSize() {
        return cellSize;
    }

    public String getCellValue(int row, int col) {
        return maze[row][col];
    }

    private void drawMaze() {
        for (int i = 0; i < maze.length; i++) {
            String[] line = maze[i];
            for (int j = 0; j < line.length; j++) {
                String cell = line[j];

                if (cell.equals("1")) {
                    Wall.drawHorizontalWall(this.beginningX + this.cellSize * j, this.beginningX + this.cellSize * (j + 1), this.beginningY + this.cellSize * (i + 1));
                }
                if (cell.equals("2")) {
                    Wall.drawVerticalWall(this.beginningY + this.cellSize * i, this.beginningY + this.cellSize * (i + 1), this.beginningX + this.cellSize * (j + 1));
                }
                if (cell.equals("3")) {
                    Wall.drawHorizontalWall(this.beginningX + this.cellSize * j, this.beginningX + this.cellSize * (j + 1), this.beginningY + this.cellSize * (i + 1));
                    Wall.drawVerticalWall(this.beginningY + this.cellSize * i, this.beginningY + this.cellSize * (i + 1), this.beginningX + this.cellSize * (j + 1));
                }
                if (cell.equals("P")) {
                    Pacman pacMan = new Pacman(this, this.beginningX + this.cellSize * j, this.beginningY + this.cellSize * i);
                    pacMan.init();
                }
                Coin.drawCoin(this.beginningX + this.cellSize * j, this.beginningY + this.cellSize * i, 15, 15);
            }
        }
    }
}

