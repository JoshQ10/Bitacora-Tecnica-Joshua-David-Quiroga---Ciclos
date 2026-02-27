package semana3.AbstractFactory;

public interface ConsoleFactory {
    Control createControl();
    Game createGame();
    GraphicInterface createGraphicInterface();
}
