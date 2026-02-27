package semana3.AbstractFactory;

public class PlayStationFactory implements ConsoleFactory {
    @Override
    public Control createControl() {
        return new PlayStationControl();
    }

    @Override
    public Game createGame() {
        return new PlayStationGame();
    }

    @Override
    public GraphicInterface createGraphicInterface() {
        return new PlayStationGraphicInterface();
    }
}
