package semana3.Builder;

public class ToyFactory {

    public void constructDoll(DollBuilder builder) {
        builder.buildHead();
        builder.buildBody();
        builder.buildArms();
        builder.buildLegs();
        builder.buildAccessories();
    }
}
