import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Colorable;
import org.academiadecodigo.simplegraphics.graphics.Line;

public class Wall { // serve para criar linhas mais grossas 3em1

    public static void drawHorizontalWall(int beginning, int end, int horizontalPosition){
        Line line = new Line(beginning,horizontalPosition,end,horizontalPosition);
        Line line2 = new Line(beginning,horizontalPosition-0.5,end,horizontalPosition-0.5);
        Line line3 = new Line(beginning,horizontalPosition-1,end,horizontalPosition-1);
        line.setColor(Color.BLUE);
        line2.setColor(Color.BLUE);
        line3.setColor(Color.BLUE);
        line.draw();
        line2.draw();
        line3.draw();
    }

    public static void drawVerticalWall(int beginning, int end, int verticalPosition){
        Line line = new Line(verticalPosition, beginning, verticalPosition, end);
        Line line2 = new Line(verticalPosition+0.5, beginning, verticalPosition+0.5, end);
        Line line3 = new Line(verticalPosition+1, beginning, verticalPosition+1, end);
        line.setColor(Color.BLUE);
        line2.setColor(Color.BLUE);
        line3.setColor(Color.BLUE);
        line.draw();
        line2.draw();
        line3.draw();
    }
}
