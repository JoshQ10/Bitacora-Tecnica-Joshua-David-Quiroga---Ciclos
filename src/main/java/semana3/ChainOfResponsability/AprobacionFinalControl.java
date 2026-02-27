package semana3.ChainOfResponsability;

public class AprobacionFinalControl extends ControlMigratorio {
    @Override
    public void procesar(IngresoRequest request) {
        System.out.println("=== Aprobación Final por Migración ===");
        System.out.println("✅ ¡BIENVENIDO A ESTADOS UNIDOS! Ingreso aprobado.\n");
    }
}
