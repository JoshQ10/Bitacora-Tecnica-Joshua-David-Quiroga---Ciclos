package semana3.ChainOfResponsability;

public abstract class ControlMigratorio {
    private ControlMigratorio siguiente;

    public void setSiguiente(ControlMigratorio siguiente) {
        this.siguiente = siguiente;
    }

    public abstract void procesar(IngresoRequest request);

    protected void pasarAlSiguiente(IngresoRequest request) {
        if (siguiente != null) {
            siguiente.procesar(request);
        }
    }
}
