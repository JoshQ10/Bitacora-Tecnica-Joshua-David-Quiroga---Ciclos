package semana3.ChainOfResponsability;

public class AntecedentesControl extends ControlMigratorio {
    @Override
    public void procesar(IngresoRequest request) {
        System.out.println("=== Control de Antecedentes ===");
        if (request.isSinAntecedentes()) {
            System.out.println("✅ Sin antecedentes penales. Puede continuar.\n");
            pasarAlSiguiente(request);
        } else {
            System.out.println("Se encontraron antecedentes penales. INGRESO DENEGADO.\n");
        }
    }
}
