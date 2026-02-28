package semana2.patrones.ejercicio2;

public class Main {
    public static void main(String[] args) {

        Mensaje msg1 = new Mensaje("Reunion programada para el lunes");
        Mensaje msg2 = new Mensaje("Informe de ventas finalizado");

        // Usando la impresora basica directamente
        System.out.println("--- IMPRESORA BASICA ---");
        Impresora basica = new ImpresoraBasica();
        basica.imprimir(msg1.getTexto());
        System.out.println();

        // Usando la impresora detallada A TRAVES del adaptador
        System.out.println("--- IMPRESORA DETALLADA (via Adapter) ---");
        ImpresoraDetallada detallada = new ImpresoraDetallada();
        Impresora adaptada = new AdaptadorImpresora(detallada, "Carlos Mendez");
        adaptada.imprimir(msg2.getTexto());

        // Ambas se usan con la misma interfaz
        System.out.println("--- POLIMORFISMO EN ACCION ---");
        Impresora[] impresoras = { basica, adaptada };
        for (Impresora imp : impresoras) {
            imp.imprimir("Mensaje de prueba universal");
        }
    }
}
