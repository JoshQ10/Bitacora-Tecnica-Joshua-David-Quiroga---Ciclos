package semana3.Decorator;

public class AntitorpedosDecorator extends BarcoDecorator {

    public AntitorpedosDecorator(Barco barcoDecorado) {
        super(barcoDecorado);
    }

    @Override
    public String getDescripcion() {
        return barcoDecorado.getDescripcion() + " + Sistema Antitorpedos";
    }

    @Override
    public int poderAtaque() {
        return barcoDecorado.poderAtaque() + 20;
    }
}
