package semana3.Builder;

public class ClassicDollBuilder implements DollBuilder {

    private ToyDoll doll = new ToyDoll();

    @Override
    public void buildHead() {
        doll.setHead("Cabeza con cabello largo rubio");
    }

    @Override
    public void buildBody() {
        doll.setBody("Cuerpo con vestido rosado");
    }

    @Override
    public void buildArms() {
        doll.setArms("Brazos con pulseras");
    }

    @Override
    public void buildLegs() {
        doll.setLegs("Piernas con zapatos de tacón");
    }

    @Override
    public void buildAccessories() {
        // No tiene accesorios
        doll.setAccessories(null);
    }

    @Override
    public ToyDoll getResult() {
        return doll;
    }
}
