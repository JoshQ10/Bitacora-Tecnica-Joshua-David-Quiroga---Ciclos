package semana3.Decorator;

public class BlindajeDecorator extends BarcoDecorator {

    public BlindajeDecorator(Barco barcoDecorado) {
        super(barcoDecorado);
    }

    @Override
    public String getDescripcion() {
        return barcoDecorado.getDescripcion() + " + Blindaje Reforzado";
    }

    @Override
    public int defensa() {
        return barcoDecorado.defensa() + 30;
    }
}
