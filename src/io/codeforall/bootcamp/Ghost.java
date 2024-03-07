package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ghost {

    private enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        NO_DIRECTION;

    }

    private Picture ghost;

    public final int distance = 20; // Speed
    private Grid pos;
    private int x;
    private int y;
    private Direction currentDirection = Direction.NO_DIRECTION;

    public Ghost(Grid pos, int x, int y) {
        this.pos = pos;
        this.x = x;
        this.y = y;

        this.ghost = new Picture(x, y, "Resources/AntonioCosta.png"); // Adjust the size according to the new cell size
        this.ghost.draw();

    }

    private Direction changeDirection() {
        if (currentDirection == Direction.NO_DIRECTION) {
            int rnd = (int) (Math.random() * 4);
            switch (rnd) {
                case 0:
                    currentDirection = Direction.DOWN;
                    break;
                case 1:
                    currentDirection = Direction.LEFT;
                    break;
                case 2:
                    currentDirection = Direction.RIGHT;
                    break;
                case 3:
                    currentDirection = Direction.UP;
                    break;
            }

        }
        return currentDirection;
    }

    public void move() {
       if(currentDirection == Direction.NO_DIRECTION){
           changeDirection();
           name(currentDirection);
           return;
       }
       name(currentDirection);
    }

    public void moveUp() {
        if (!willCollide(x, y - distance)) {
            ghost.translate(0, -distance);
            y -= distance;
            return;
        }
        currentDirection = Direction.NO_DIRECTION;
    }

    public void moveDown() {
        if (!willCollide(x, y + pos.getCellSize())) {
            ghost.translate(0, distance);
            y += distance;
            return;
        }
        currentDirection = Direction.NO_DIRECTION;
    }

    public void moveLeft() {
        if (!willCollide(x - distance, y)) {
            ghost.translate(-distance, 0);
            x -= distance;
            return;
        }
        currentDirection = Direction.NO_DIRECTION;
    }

    public void moveRight() {
        int rightBound = pos.getBeginningX() + pos.getWidth() * pos.getCellSize();
        if (!willCollide(x + pos.getCellSize(), y) && x < rightBound - pos.getCellSize()) {
            ghost.translate(distance, 0);
            x += distance;
            return;
        }
        currentDirection = Direction.NO_DIRECTION;
    }

    private void name(Direction direction){
        switch (direction){
            case RIGHT:
                moveRight();
                break;
            case LEFT:
                moveLeft();
                break;
            case DOWN:
                moveDown();
                break;
            case UP:
                moveUp();
                break;
            case NO_DIRECTION:
                break;
        }
    }

    private boolean willCollide(int newX, int newY) {
        int gridX = (newX - pos.getBeginningX()) / pos.getCellSize();
        int gridY = (newY - pos.getBeginningY()) / pos.getCellSize();
        if (gridX < 0 || gridX >= pos.getWidth() || gridY < 0 || gridY >= pos.getHeight()) {
            return true;
        }

        // Check if the new position overlaps with a wall represented by "1" in the maze
        String cellValue = pos.getCellValue(gridY, gridX);
        return cellValue.equals("1");
    }

    //public Picture getGhost() {
        //return ghost;
    //}

    public int getWidth() {
        return ghost.getWidth();
    }

    public int getHeight() {
        return ghost.getHeight();
    }

    public int getX() {
        return ghost.getX();
    }

    public int getY() {
        return ghost.getY();
    }

    public Grid getPos() {
        return this.pos;
    }


}
