import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Pacman implements KeyboardHandler {
    private Ellipse currentPacMan;
    private Keyboard keyboard;
    private int lifes = 3;
    public final int distance = 10; // Speed
    private Grid pos;
    private int x;
    private int y;

    public Pacman(Grid pos, int x, int y) {
        this.pos = pos;
        this.x = x;
        this.y = y;

        this.currentPacMan = new Ellipse(x, y, pos.getCellSize() - 10, pos.getCellSize() - 10); // Adjust the size according to the new cell size
        this.currentPacMan.setColor(Color.YELLOW);
        this.currentPacMan.fill();
    }

    public void moveUp() {
        if (!willCollide(x, y - distance)) {
            this.currentPacMan.translate(0, -distance);
            y -= distance;
        }
    }

    public void moveDown() {
        if (!willCollide(x, y + distance)) {
            this.currentPacMan.translate(0, distance);
            y += distance;
        }
    }

    public void moveLeft() {
        if (!willCollide(x - distance, y)) {
            this.currentPacMan.translate(-distance, 0);
            x -= distance;
        }
    }

    public void moveRight() {
        if (!willCollide(x + distance, y)) {
            this.currentPacMan.translate(distance, 0);
            x += distance;
        }
    }

    private boolean willCollide(int newX, int newY) {
        int gridX = (newX - pos.getBeginningX()) / pos.getCellSize();
        int gridY = (newY - pos.getBeginningY()) / pos.getCellSize();

        // Check if the new position overlaps with a wall represented by "1" in the maze
        String cellValue = pos.getCellValue(gridY, gridX);
        return cellValue.equals("1");
    }

    public void die() {
        this.currentPacMan.delete();
        lifes--;
    }

    public void revive() {
        this.currentPacMan.draw();
    }

    public int getWidth() {
        return this.currentPacMan.getWidth();
    }

    public int getHeight() {
        return this.currentPacMan.getHeight();
    }

    public Grid getPos() {
        return this.pos;
    }

    public void init() {
        this.keyboard = new Keyboard(this);

        KeyboardEvent pressedRight = new KeyboardEvent();
        pressedRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedRight.setKey(39);
        this.keyboard.addEventListener(pressedRight);

        KeyboardEvent pressedLeft = new KeyboardEvent();
        pressedLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedLeft.setKey(37);
        this.keyboard.addEventListener(pressedLeft);

        KeyboardEvent pressedUp = new KeyboardEvent();
        pressedUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedUp.setKey(38);
        this.keyboard.addEventListener(pressedUp);

        KeyboardEvent pressedDown = new KeyboardEvent();
        pressedDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedDown.setKey(40);
        this.keyboard.addEventListener(pressedDown);

        KeyboardEvent releasedRight = new KeyboardEvent();
        releasedRight.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releasedRight.setKey(39);
        this.keyboard.addEventListener(releasedRight);

        KeyboardEvent releasedLeft = new KeyboardEvent();
        releasedLeft.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releasedLeft.setKey(37);
        this.keyboard.addEventListener(releasedLeft);

        KeyboardEvent releasedUp = new KeyboardEvent();
        releasedUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releasedUp.setKey(38);
        this.keyboard.addEventListener(releasedUp);

        KeyboardEvent releasedDown = new KeyboardEvent();
        releasedDown.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releasedDown.setKey(40);
        this.keyboard.addEventListener(releasedDown);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case 37:
                this.moveLeft();
                break;
            case 38:
                this.moveUp();
                break;
            case 39:
                this.moveRight();
                break;
            case 40:
                this.moveDown();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
