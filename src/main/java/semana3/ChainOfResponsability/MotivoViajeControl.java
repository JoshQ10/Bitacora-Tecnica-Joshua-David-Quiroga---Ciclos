package semana3.ChainOfResponsability;

public class MotivoViajeControl extends ControlMigratorio {
    @Override
    public void procesar(IngresoRequest request) {
        System.out.println("=== Revisión de Motivo del Viaje ===");
        if (request.isMotivoValido()) {
            System.out.println("✅ Motivo del viaje aceptado. Puede continuar.\n");
            pasarAlSiguiente(request);
        } else {
            System.out.println("Motivo del viaje sospechoso. INGRESO DENEGADO.\n");
        }
    }
}
