package semana3.ChainOfResponsability;

public class Main {
    public static void main(String[] args) {

        ControlMigratorio pasaporte = new PasaporteControl();
        ControlMigratorio antecedentes = new AntecedentesControl();
        ControlMigratorio motivo = new MotivoViajeControl();
        ControlMigratorio aprobacion = new AprobacionFinalControl();

        // Armar la cadena
        pasaporte.setSiguiente(antecedentes);
        antecedentes.setSiguiente(motivo);
        motivo.setSiguiente(aprobacion);

        // Persona con motivo de viaje inválido
        IngresoRequest persona = new IngresoRequest(
                true,   // pasaporte válido
                true,   // sin antecedentes
                false   // motivo NO válido
        );

        pasaporte.procesar(persona);
    }
}
