import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Heart {

    private Picture image;
    private boolean alive;

    public Heart(int x, int y, String imagePath) {
        image = new Picture(x, y, imagePath);
        image.draw();
        alive = true;
    }

    public void delete() {
        image.delete();
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }
}
