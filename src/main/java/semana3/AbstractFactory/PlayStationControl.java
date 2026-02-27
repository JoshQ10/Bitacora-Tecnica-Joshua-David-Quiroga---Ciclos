package semana3.AbstractFactory;

public class PlayStationControl implements Control {
    @Override
    public void connect() {
        System.out.println("Conectando control de PlayStation (DualSense)");
    }
}
