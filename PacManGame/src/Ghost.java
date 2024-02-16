import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

public class Ghost {

    private enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        NO_DIRECTION;

    }

    private Ellipse ghost;

    public final int distance = 20; // Speed
    private Grid pos;
    private int x;
    private int y;
    private Direction currentDirection = Direction.NO_DIRECTION;

    public Ghost(Grid pos, int x, int y) {
        this.pos = pos;
        this.x = x;
        this.y = y;

        this.ghost = new Ellipse(x, y, pos.getCellSize() - 10, pos.getCellSize() - 10); // Adjust the size according to the new cell size
        this.ghost.setColor(Color.PINK);
        this.ghost.fill();

    }

    private Direction changeDirection() {
        if (currentDirection == Direction.NO_DIRECTION) {
            int rnd = (int) (Math.random() * 4);
            switch (rnd) {
                case 0:
                    moveDown();
                    currentDirection = Direction.DOWN;
                    break;
                case 1:
                    moveLeft();
                    currentDirection = Direction.LEFT;
                    break;
                case 2:
                    moveRight();
                    currentDirection = Direction.RIGHT;
                    break;
                case 3:
                    moveUp();
                    currentDirection = Direction.UP;
                    break;
            }

        }
        return currentDirection;
    }

    public void move() {
       if(currentDirection == Direction.NO_DIRECTION){
           changeDirection();
       }
       name(currentDirection);
    }

    public void moveUp() {
        if (!willCollide(x, y - distance)) {
            this.ghost.translate(0, -distance);
            y -= distance;
            return;
        }
        currentDirection = Direction.NO_DIRECTION;
    }

    public void moveDown() {
        if (!willCollide(x, y + distance + 35)) {
            this.ghost.translate(0, distance);
            y += distance;
            return;
        }
        currentDirection = Direction.NO_DIRECTION;
    }

    public void moveLeft() {
        if (!willCollide(x - distance, y)) {
            this.ghost.translate(-distance, 0);
            x -= distance;
            return;
        }
        currentDirection = Direction.NO_DIRECTION;
    }

    public void moveRight() {
        if (!willCollide(x + distance + 35, y)) {
            this.ghost.translate(distance, 0);
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
        }
    }

    private boolean willCollide(int newX, int newY) {
        int gridX = (newX - pos.getBeginningX()) / pos.getCellSize();
        int gridY = (newY - pos.getBeginningY()) / pos.getCellSize();

        // Check if the new position overlaps with a wall represented by "1" in the maze
        String cellValue = pos.getCellValue(gridY, gridX);
        return cellValue.equals("1");
    }


    public int getWidth() {
        return this.ghost.getWidth();
    }

    public int getHeight() {
        return this.ghost.getHeight();
    }

    public Grid getPos() {
        return this.pos;
    }


}
