package semana3.Builder;

public interface DollBuilder {
    void buildHead();
    void buildBody();
    void buildArms();
    void buildLegs();
    void buildAccessories();
    ToyDoll getResult();
}
