package semana3.Decorator;

public class RadarDecorator extends BarcoDecorator {

    public RadarDecorator(Barco barcoDecorado) {
        super(barcoDecorado);
    }

    @Override
    public String getDescripcion() {
        return barcoDecorado.getDescripcion() + " + Radar Avanzado";
    }

    @Override
    public int poderAtaque() {
        return barcoDecorado.poderAtaque() + 10;
    }
}
