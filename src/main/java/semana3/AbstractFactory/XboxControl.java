package semana3.AbstractFactory;

public class XboxControl implements Control {
    @Override
    public void connect() {
        System.out.println("Conectando control de Xbox (Xbox Wireless)");
    }
}
