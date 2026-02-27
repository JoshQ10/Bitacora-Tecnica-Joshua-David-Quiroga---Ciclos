package semana3.Adapter;

public class GasPump implements FuelService {
    @Override
    public void supply(double liters) {
        System.out.println("Suministrando " + liters + " litros de gasolina");
    }
}
