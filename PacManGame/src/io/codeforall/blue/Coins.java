package io.codeforall.blue;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Coins extends GameObjects{

    private Picture coin;
    private int points;

    public Coins() {
        points = 10;

    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
