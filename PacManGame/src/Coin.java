import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Coin {
    public static void drawCoin(int beginningX, int beginningY, int width, int height){
        Ellipse coin = new Ellipse(beginningX+20,beginningY+20,width,height);
        coin.setColor(Color.ORANGE);
        coin.fill();

    }
}
