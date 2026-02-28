package semana2.patrones.ejercicio3;

public class Main {
    public static void main(String[] args) {

        EditorTexto editor = new EditorTexto();
        Historial historial = new Historial();

        // Primera escritura
        editor.escribir("Hola mundo");
        historial.guardar(editor.guardar());
        System.out.println("Escribiendo...");
        editor.mostrarEstado();
        System.out.println("  Respaldos guardados: " + historial.verTamanio());
        System.out.println();

        // Segunda escritura
        editor.escribir("Hola mundo. Este es mi editor.");
        historial.guardar(editor.guardar());
        System.out.println("Escribiendo...");
        editor.mostrarEstado();
        System.out.println("  Respaldos guardados: " + historial.verTamanio());
        System.out.println();

        // Tercera escritura
        editor.escribir("Hola mundo. Este es mi editor. Version final.");
        System.out.println("Escribiendo...");
        editor.mostrarEstado();
        System.out.println("  Respaldos guardados: " + historial.verTamanio());
        System.out.println();

        // Deshacer 1
        System.out.println("Deshaciendo...");
        Respaldo anterior = historial.recuperar();
        if (anterior != null) {
            editor.restaurar(anterior);
        }
        editor.mostrarEstado();
        System.out.println("  Respaldos restantes: " + historial.verTamanio());
        System.out.println();

        // Deshacer 2
        System.out.println("Deshaciendo...");
        anterior = historial.recuperar();
        if (anterior != null) {
            editor.restaurar(anterior);
        }
        editor.mostrarEstado();
        System.out.println("  Respaldos restantes: " + historial.verTamanio());
        System.out.println();

        // Deshacer 3 (ya no hay mas)
        System.out.println("Deshaciendo...");
        anterior = historial.recuperar();
        if (anterior != null) {
            editor.restaurar(anterior);
        }
    }
}
