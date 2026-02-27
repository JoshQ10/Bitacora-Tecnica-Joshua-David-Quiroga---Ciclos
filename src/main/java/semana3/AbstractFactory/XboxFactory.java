package semana3.AbstractFactory;

public class XboxFactory implements ConsoleFactory {
    @Override
    public Control createControl() {
        return new XboxControl();
    }

    @Override
    public Game createGame() {
        return new XboxGame();
    }

    @Override
    public GraphicInterface createGraphicInterface() {
        return new XboxGraphicInterface();
    }
}
