package io.codeforall.blue;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PacMan extends GameObjects implements Movable{

    private Picture[] pacMan = new Picture[4];
    private Picture currentPacMan;
    private int lifes = 3;
    public final int distance = 10;

    public PacMan() {
        currentPacMan = new Picture();
        createPacManArray();
        currentPacMan = pacMan[3];
        currentPacMan.draw();
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

    private void createPacManArray(){
        pacMan[0] = new Picture(currentPacMan.getX(), currentPacMan.getY(),"Resources/PacManUp.png");
        pacMan[1] = new Picture(currentPacMan.getX(), currentPacMan.getY(),"Resources/PacManDown.png");
        pacMan[2] = new Picture(currentPacMan.getX(), currentPacMan.getY(),"Resources/PacManLeft.png");
        pacMan[3] = new Picture(currentPacMan.getX(), currentPacMan.getY(),"Resources/PacManRight.png");
    }
    public int getWidth(){
        return currentPacMan.getWidth();
    }

    public int getHeight(){
        return currentPacMan.getHeight();
    }
}
