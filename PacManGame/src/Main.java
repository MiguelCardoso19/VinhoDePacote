import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Main implements KeyboardHandler {

    private Picture startMenu;
    private boolean gameStarted = false;

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
    }

    public void init() {
        startMenu = new Picture(10, 10, "Resources/presstoplay.jpg");
        startMenu.draw();

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent startEvent = new KeyboardEvent();
        startEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        startEvent.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(startEvent);

        while (!gameStarted) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        startMenu.delete();
        startGame();
    }

    private void startGame() {
        Grid grid = new Grid(10, 10);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        gameStarted = true;
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}