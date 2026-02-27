package semana3.AbstractFactory;

public class GameEngine {

    private Control control;
    private Game game;
    private GraphicInterface graphicInterface;

    public GameEngine(ConsoleFactory factory) {
        this.control = factory.createControl();
        this.game = factory.createGame();
        this.graphicInterface = factory.createGraphicInterface();
    }

    public void run() {
        control.connect();
        game.start();
        graphicInterface.render();
    }
}
