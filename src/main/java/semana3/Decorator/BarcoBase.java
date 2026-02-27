package semana3.Decorator;

public class BarcoBase implements Barco {

    @Override
    public String getDescripcion() {
        return "Barco de guerra estándar";
    }

    @Override
    public int poderAtaque() {
        return 50;
    }

    @Override
    public int defensa() {
        return 40;
    }
}
