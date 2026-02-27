package semana3.Builder;

public class ActionDollBuilder implements DollBuilder {

    private ToyDoll doll = new ToyDoll();

    @Override
    public void buildHead() {
        doll.setHead("Cabeza con casco militar");
    }

    @Override
    public void buildBody() {
        doll.setBody("Cuerpo musculoso con armadura");
    }

    @Override
    public void buildArms() {
        doll.setArms("Brazos articulados con guantes");
    }

    @Override
    public void buildLegs() {
        doll.setLegs("Piernas con botas de combate");
    }

    @Override
    public void buildAccessories() {
        doll.setAccessories("Espada y escudo");
    }

    @Override
    public ToyDoll getResult() {
        return doll;
    }
}
