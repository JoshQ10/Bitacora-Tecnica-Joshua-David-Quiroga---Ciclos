package semana3.Adapter;

public class SmartGasStation {

    public static void main(String[] args) {

        FuelService gasolinePump = new GasPump();

        FuelService fastElectricPump =
                new FastChargerAdapter(new FastElectricCharger());

        FuelService slowElectricPump =
                new SlowChargerAdapter(new SlowElectricCharger());

        gasolinePump.supply(30);
        fastElectricPump.supply(30);
        slowElectricPump.supply(30);
    }
}
