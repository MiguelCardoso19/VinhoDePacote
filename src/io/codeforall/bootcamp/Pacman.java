package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Pacman implements KeyboardHandler {
    private Grid grid;
    private Picture currentPacMan;
    private Keyboard keyboard;
    private int lives = 4;
    public final int distance = 10; // Speed
    private Grid pos;
    private int x;
    private int y;
    private int firstX;
    private int firstY;
    private Coin[][] coins;
    private int score = 0;
    private Text score2 = new Text(690, 170, toString());

    public Pacman(Grid pos, int x, int y, Coin[][] coins) {
        this.pos = pos;
        this.x = x;
        this.y = y;
        this.firstX = x;
        this.firstY = y;
        this.coins = coins;

        this.currentPacMan = new Picture(x, y, "Resources/ZePovo.png");
        currentPacMan.draw();
        score2.grow(65, 30);
        score2.draw();
        score2.setColor(Color.WHITE);

    }

    public void moveUp() {
        if (!willCollide(x, y - distance)) {
            this.currentPacMan.translate(0, -distance);
            y -= distance;
            checkCoinCollision();
        }
    }

    public void moveDown() {
        if (!willCollide(x, y + pos.getCellSize())) {
            this.currentPacMan.translate(0, distance);
            y += distance;
            checkCoinCollision();
        }
    }

    public void moveLeft() {
        if (!willCollide(x - distance , y)) {
            this.currentPacMan.translate(-distance, 0);
            x -= distance;
            checkCoinCollision();

        }
    }

    public void moveRight() {
        int rightBound = pos.getBeginningX() + (pos.getWidth() - 1) * pos.getCellSize();
        if (!willCollide(x + pos.getCellSize(), y) && x < rightBound - pos.getCellSize()) {
            this.currentPacMan.translate(distance, 0);
            x += distance;
            checkCoinCollision();
        }
    }

    private boolean willCollide(int newX, int newY) {
        int gridX = (newX - pos.getBeginningX()) / pos.getCellSize();
        int gridY = (newY - pos.getBeginningY()) / pos.getCellSize();

        if (gridX < 0 || gridX >= pos.getWidth() || gridY < 0 || gridY >= pos.getHeight()) {
            return true;
        }

        if (pos.getCellValue(gridY, gridX).equals("1")) {
            return true;
        }

        if (pos.getCellValue(gridY, gridX).equals("0")) {
            return false;
        }

        return false;
    }

    private void checkCoinCollision() {
        int gridX = x / pos.getCellSize();
        int gridY = y / pos.getCellSize();

        if (gridX >= 0 && gridX < coins[0].length && gridY >= 0 && gridY < coins.length) {
            Coin coin = coins[gridY][gridX];
            if (coin != null && coin.getX() == x && coin.getY() == y) {
                coin.delete();
                coins[gridY][gridX] = null;
                score += 100;
                score2.setText(toString());
                score2.delete();
                score2.draw();
            }
        }
    }


    public int getScore(){
        return score;
    }

    @Override
    public String toString() {
        return "SCORE: " + score;
    }

    public void die() {
        if (lives > 1) {
            //grid.removeHeart();
            currentPacMan.delete();
            //currentPacMan = new Picture(firstX, firstY, "Resources/ZePovo.png");
            //currentPacMan.draw();
            x = firstX;
            y = firstY;
            //currentPacMan.draw();
            lives--;
            // Reset Pacman's position
            //x = grid.getBeginningX() ;
          //  y = grid.getBeginningY();
        } else {
            // End the game
            System.out.println("Game Over");
            System.exit(0);
        }
    }
    public int getX() {
        return currentPacMan.getX();
    }

    public int getY() {
        return currentPacMan.getY();
    }
    public int getWidth(){
        return currentPacMan.getWidth();
    }
    public int getHeight(){
        return currentPacMan.getHeight();
    }

    public void revive(){
        currentPacMan = new Picture(firstX, firstY, "Resources/ZePovo.png");
        currentPacMan.draw();
        x = firstX;
        y = firstY;
    }

    public void init() {
        this.keyboard = new Keyboard(this);

        KeyboardEvent pressedRight = new KeyboardEvent();
        pressedRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedRight.setKey(KeyboardEvent.KEY_RIGHT);
        this.keyboard.addEventListener(pressedRight);

        KeyboardEvent pressedLeft = new KeyboardEvent();
        pressedLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedLeft.setKey(KeyboardEvent.KEY_LEFT);
        this.keyboard.addEventListener(pressedLeft);

        KeyboardEvent pressedUp = new KeyboardEvent();
        pressedUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedUp.setKey(KeyboardEvent.KEY_UP);
        this.keyboard.addEventListener(pressedUp);

        KeyboardEvent pressedDown = new KeyboardEvent();
        pressedDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedDown.setKey(KeyboardEvent.KEY_DOWN);
        this.keyboard.addEventListener(pressedDown);

        KeyboardEvent releasedRight = new KeyboardEvent();
        releasedRight.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releasedRight.setKey(KeyboardEvent.KEY_RIGHT);
        this.keyboard.addEventListener(releasedRight);

        KeyboardEvent releasedLeft = new KeyboardEvent();
        releasedLeft.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releasedLeft.setKey(KeyboardEvent.KEY_LEFT);
        this.keyboard.addEventListener(releasedLeft);

        KeyboardEvent releasedUp = new KeyboardEvent();
        releasedUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releasedUp.setKey(KeyboardEvent.KEY_UP);
        this.keyboard.addEventListener(releasedUp);

        KeyboardEvent releasedDown = new KeyboardEvent();
        releasedDown.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releasedDown.setKey(KeyboardEvent.KEY_DOWN);
        this.keyboard.addEventListener(releasedDown);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                this.moveLeft();
                break;
            case KeyboardEvent.KEY_UP:
                this.moveUp();
                break;
            case KeyboardEvent.KEY_RIGHT:
                this.moveRight();
                break;
            case KeyboardEvent.KEY_DOWN:
                this.moveDown();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
