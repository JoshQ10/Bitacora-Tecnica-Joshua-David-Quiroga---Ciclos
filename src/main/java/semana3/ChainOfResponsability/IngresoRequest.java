package semana3.ChainOfResponsability;

public class IngresoRequest {
    private boolean pasaporteValido;
    private boolean sinAntecedentes;
    private boolean motivoValido;

    public IngresoRequest(boolean pasaporteValido, boolean sinAntecedentes, boolean motivoValido) {
        this.pasaporteValido = pasaporteValido;
        this.sinAntecedentes = sinAntecedentes;
        this.motivoValido = motivoValido;
    }

    public boolean isPasaporteValido() {
        return pasaporteValido;
    }

    public boolean isSinAntecedentes() {
        return sinAntecedentes;
    }

    public boolean isMotivoValido() {
        return motivoValido;
    }
}
