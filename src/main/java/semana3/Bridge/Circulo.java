package semana3.Bridge;

public class Circulo extends Forma {

    public Circulo(Color color) {
        super(color);
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando Círculo de color " + color.aplicar());
    }
}
