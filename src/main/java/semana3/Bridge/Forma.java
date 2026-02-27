package semana3.Bridge;

public abstract class Forma {

    protected Color color;    // ← EL PUENTE (Bridge)

    public Forma(Color color) {
        this.color = color;
    }

    public abstract void dibujar();
}
