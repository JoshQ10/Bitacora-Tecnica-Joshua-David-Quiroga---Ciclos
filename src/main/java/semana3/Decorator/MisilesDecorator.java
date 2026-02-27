package semana3.Decorator;

public class MisilesDecorator extends BarcoDecorator {

    public MisilesDecorator(Barco barcoDecorado) {
        super(barcoDecorado);
    }

    @Override
    public String getDescripcion() {
        return barcoDecorado.getDescripcion() + " + Misiles";
    }

    @Override
    public int poderAtaque() {
        return barcoDecorado.poderAtaque() + 40;
    }
}
