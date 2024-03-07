package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {
    public static final int CELL_SIZE = 50;

    private int beginningX;
    private int beginningY;
    private int width;
    private int height;
    private Ghost[] ghosts;



    private String[][] maze = {
            {"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1"},
            {"1", "P", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "2", "2", "2", "2", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1"},
            {"1", "0", "1", "1", "1", "1", "1", "1", "0", "1", "0", "1", "3", "3", "3", "3", "1", "0", "1", "0", "1", "1", "1", "1", "1", "1", "0", "1"},
            {"1", "0", "1", "0", "0", "0", "0", "0", "0", "1", "0", "1", "3", "3", "3", "3", "1", "0", "1", "0", "0", "0", "0", "0", "0", "1", "0", "1"},
            {"1", "0", "1", "0", "1", "1", "1", "1", "0", "1", "0", "1", "1", "1", "1", "1", "1", "0", "1", "0", "1", "1", "1", "1", "0", "1", "0", "1"},
            {"1", "0", "0", "0", "1", "0", "0", "0", "0", "1", "0", "0", "0", "0", "0", "0", "0", "0", "1", "0", "0", "0", "0", "1", "0", "0", "0", "1"},
            {"1", "1", "1", "0", "1", "0", "1", "1", "0", "1", "1", "0", "1", "1", "1", "1", "0", "1", "1", "0", "1", "1", "0", "1", "0", "1", "1", "1"},
            {"1", "0", "0", "0", "0", "0", "0", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "0", "0", "0", "0", "0", "0", "1"},
            {"1", "0", "1", "0", "1", "1", "0", "1", "0", "1", "1", "1", "1", "3", "3", "1", "1", "1", "1", "0", "1", "0", "1", "1", "0", "1", "0", "1"},
            {"1", "0", "1", "0", "1", "1", "0", "1", "0", "1", "3", "3", "3", "3", "3", "3", "3", "3", "1", "0", "1", "0", "1", "1", "0", "1", "0", "1"},
            {"1", "0", "1", "0", "1", "1", "0", "1", "0", "3", "3", "3", "3", "3", "G", "3", "3", "3", "3", "0", "1", "0", "1", "1", "0", "1", "0", "1"},
            {"1", "0", "1", "0", "0", "0", "0", "0", "0", "1", "3", "3", "3", "3", "3", "3", "3", "3", "1", "0", "0", "0", "0", "0", "0", "1", "0", "1"},
            {"1", "0", "0", "0", "1", "0", "1", "1", "0", "1", "1", "1", "1", "3", "3", "1", "1", "1", "1", "0", "1", "1", "0", "1", "0", "0", "0", "1"},
            {"1", "1", "1", "0", "1", "0", "1", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "1", "0", "1", "0", "1", "1", "1"},
            {"1", "0", "0", "0", "1", "0", "0", "0", "0", "1", "1", "0", "1", "1", "1", "1", "0", "1", "1", "0", "0", "0", "0", "1", "0", "0", "0", "1"},
            {"1", "0", "1", "0", "1", "1", "1", "1", "0", "1", "0", "0", "0", "0", "0", "0", "0", "0", "1", "0", "1", "1", "1", "1", "0", "1", "0", "1"},
            {"1", "0", "1", "0", "0", "0", "0", "0", "0", "1", "0", "1", "1", "1", "1", "1", "1", "0", "1", "0", "0", "0", "0", "0", "0", "1", "0", "1"},
            {"1", "0", "1", "1", "1", "1", "1", "1", "0", "1", "0", "1", "1", "1", "1", "1", "1", "0", "1", "0", "1", "1", "1", "1", "1", "1", "0", "1"},
            {"1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1"},
            {"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1"}
    };

    private Pacman pacman;
    private Coin[][] coins;
    private Heart[] hearts;

    public Grid(int beginningX, int beginningY) {
        this.width = maze[0].length;
        this.height = maze.length;
        this.beginningX = beginningX;
        this.beginningY = beginningY;

        coins = new Coin[height][width];
        drawMaze();
        createGhosts();
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
        return CELL_SIZE;
    }

    public String getCellValue(int row, int col) {
        return maze[row][col];
    }
    public void removeHeart() {
        // Find the last heart in the hearts array
        for (int i = hearts.length - 1; i >= 0; i--) {
            if (hearts[i] != null) {
                // Remove the heart from the screen
                hearts[i].delete();
                // Remove the heart from the hearts array
                hearts[i] = null;
                break;
            }
        }
    }
    private void drawMaze() {
        Rectangle background = new Rectangle(beginningX, beginningY, width * CELL_SIZE, height * CELL_SIZE);
        background.setColor(Color.BLACK);
        background.fill();

        for (int i = 0; i < maze.length; i++) {
            String[] line = maze[i];
            for (int j = 0; j < line.length; j++) {
                String cell = line[j];

                int x = this.beginningX + this.CELL_SIZE * j;
                int y = this.beginningY + this.CELL_SIZE * i;

                if (cell.equals("1")) { //Rectangle(Wall)
                    Rectangle wall = new Rectangle(x, y, CELL_SIZE, CELL_SIZE);
                    wall.setColor(Color.BLUE);
                    wall.fill();
                } else if (cell.equals("P")) { //Pacman
                    pacman = new Pacman(this, x, y, coins);
                    pacman.init();
                } else if (cell.equals("0")) { //Coin
                    Coin coin = new Coin(x, y, "Resources/wine.png");
                    coins[i][j] = coin;

                } else if (cell.equals("2")) { //Heart
                    if (hearts == null) {
                        hearts = new Heart[4];
                    }
                    for (int k = 0; k < hearts.length; k++) {
                        if (hearts[k] == null) {
                            hearts[k] = new Heart(x, y, "Resources/heart.png");
                            break;
                        }
                    }
                }

            }
        }
    }
        private void createGhosts() {
            for (int i = 0; i < maze.length; i++) {
                String[] line = maze[i];
                for (int j = 0; j < line.length; j++) {
                    String cell = line[j];

                    int x = this.beginningX + this.CELL_SIZE * j;
                    int y = this.beginningY + this.CELL_SIZE * i;
                    if (cell.equals("G")) {
                        ghosts = new Ghost[4];
                        for (int h = 0; h < ghosts.length; h++) {
                            ghosts[h] = new Ghost(this, x, y);
                        }

                    }
                }
            }
        }

    public void init() throws InterruptedException {
        while (true) {
            Thread.sleep(200);
            for (Ghost g : ghosts) {
            int num = 0;
            while (num < 3) {
                //for (Ghost g : ghosts) {
                    g.move();
                   checkGhosts(g);
                num++;
                }
                //num++;
            }
        }
    }
   private void checkGhosts(Ghost ghost) {
            if (pacman.getX() <= ghost.getX() && ghost.getX() <= pacman.getX() + pacman.getWidth() &&
                    pacman.getY() <= ghost.getY() && ghost.getY() <= pacman.getY() + pacman.getHeight()){
                System.out.println("Pacman died");
                pacman.die();
                removeHeart();
                pacman.revive();
            }
    }
}
