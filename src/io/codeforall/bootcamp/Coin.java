package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Coin {
    private int x;
    private int y;
    private Picture coinPicture;

    public Coin(int x, int y, String picturePath) {
        this.x = x;
        this.y = y;
        this.coinPicture = new Picture(x, y, picturePath);
        this.coinPicture.draw();
    }

    public void delete() {
        coinPicture.delete();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
