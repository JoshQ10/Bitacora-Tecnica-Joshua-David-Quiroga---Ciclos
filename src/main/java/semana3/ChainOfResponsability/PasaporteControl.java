package semana3.ChainOfResponsability;

public class PasaporteControl extends ControlMigratorio {
    @Override
    public void procesar(IngresoRequest request) {
        System.out.println("=== Control de Pasaporte y Visa ===");
        if (request.isPasaporteValido()) {
            System.out.println("✅ Pasaporte y visa válidos. Puede continuar.\n");
            pasarAlSiguiente(request);
        } else {
            System.out.println("Pasaporte o visa inválidos. INGRESO DENEGADO.\n");
        }
    }
}
