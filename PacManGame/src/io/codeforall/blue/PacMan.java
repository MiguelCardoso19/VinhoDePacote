package io.codeforall.blue;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PacMan extends GameObjects implements Movable{

    private Picture[] pacMan = new Picture[4];
    private Picture currentPacMan;
    private int lifes = 3;
    public final int distance = 10;

    @Override
    public void moveUp() {
        currentPacMan = pacMan[0];
        currentPacMan.translate(0, -distance);
    }

    @Override
    public void moveDown() {
        currentPacMan = pacMan[1];
        currentPacMan.translate(0, distance);
    }

    @Override
    public void moveLeft() {
        currentPacMan = pacMan[2];
        currentPacMan.translate(-distance, 0);
    }

    @Override
    public void moveRight() {
        currentPacMan = pacMan[3];
        currentPacMan.translate(distance, 0);
    }

    public void die(){
        currentPacMan.delete();
        lifes--;
    }
    public void revive(){
        currentPacMan.draw();
    }
}
