package io.codeforall.blue;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PacMan extends GameObjects implements Movable, KeyboardHandler {

    private Picture currentPacMan;
    private Keyboard keyboard;
    private int lifes = 3;
    public final int distance = 10;

    public PacMan() {
        currentPacMan = new Picture();
        currentPacMan = new Picture(currentPacMan.getX(), currentPacMan.getY(),"Resources/PacManRight.png");;
        currentPacMan.draw();
        init();
    }

    @Override
    public void moveUp() {
        currentPacMan.delete();
        currentPacMan = new Picture(currentPacMan.getX(), currentPacMan.getY(),"Resources/PacManUp.png");
        currentPacMan.draw();
        currentPacMan.translate(0, -distance);
    }

    @Override
    public void moveDown() {
        currentPacMan.delete();
        currentPacMan = new Picture(currentPacMan.getX(), currentPacMan.getY(),"Resources/PacManDown.png");
        currentPacMan.draw();
        currentPacMan.translate(0, distance);
    }

    @Override
    public void moveLeft() {
        currentPacMan.delete();
        currentPacMan = new Picture(currentPacMan.getX(), currentPacMan.getY(),"Resources/PacManLeft.png");
        currentPacMan.draw();
        currentPacMan.translate(-distance, 0);
    }

    @Override
    public void moveRight() {
        currentPacMan.delete();
        currentPacMan = new Picture(currentPacMan.getX(), currentPacMan.getY(),"Resources/PacManRight.png");
        currentPacMan.draw();
        currentPacMan.translate(distance, 0);
    }

    public void die(){
        currentPacMan.delete();
        lifes--;
    }
    public void revive(){
        currentPacMan.draw();
    }

    public int getWidth(){
        return currentPacMan.getWidth();
    }

    public int getHeight(){
        return currentPacMan.getHeight();
    }
    public void init() {

        keyboard = new Keyboard(this);
        KeyboardEvent pressedRight = new KeyboardEvent();
        pressedRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(pressedRight);

        KeyboardEvent pressedLeft = new KeyboardEvent();
        pressedLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(pressedLeft);

        KeyboardEvent pressedUp = new KeyboardEvent();
        pressedUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedUp.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(pressedUp);

        KeyboardEvent pressedDown = new KeyboardEvent();
        pressedDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(pressedDown);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                moveRight();
                break;
            case KeyboardEvent.KEY_LEFT:
                moveLeft();
                break;
            case KeyboardEvent.KEY_UP:
                moveUp();
                break;
            case KeyboardEvent.KEY_DOWN:
                moveDown();
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
