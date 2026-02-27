package semana3.Decorator;

public abstract class BarcoDecorator implements Barco {

    protected Barco barcoDecorado;    // ← ENVUELVE a otro barco

    public BarcoDecorator(Barco barcoDecorado) {
        this.barcoDecorado = barcoDecorado;
    }

    @Override
    public String getDescripcion() {
        return barcoDecorado.getDescripcion();
    }

    @Override
    public int poderAtaque() {
        return barcoDecorado.poderAtaque();
    }

    @Override
    public int defensa() {
        return barcoDecorado.defensa();
    }
}
