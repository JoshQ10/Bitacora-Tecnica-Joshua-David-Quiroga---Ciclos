package semana3.Adapter;

public class SlowChargerAdapter implements FuelService {

    private SlowElectricCharger charger;

    public SlowChargerAdapter(SlowElectricCharger charger) {
        this.charger = charger;
    }

    @Override
    public void supply(double liters) {
        double kwh = liters * 7.0;
        charger.slowCharge(kwh);
    }
}
