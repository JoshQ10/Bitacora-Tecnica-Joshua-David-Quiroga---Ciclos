package semana2.patrones.ejercicio3;

public class EditorTexto {
    private String contenido;

    public EditorTexto() {
        this.contenido = "";
    }

    public void escribir(String nuevoTexto) {
        this.contenido = nuevoTexto;
    }

    public String getContenido() {
        return contenido;
    }

    // Crea un respaldo del estado actual
    public Respaldo guardar() {
        return new Respaldo(contenido);
    }

    // Restaura el estado desde un respaldo
    public void restaurar(Respaldo respaldo) {
        this.contenido = respaldo.obtenerContenido();
    }

    public void mostrarEstado() {
        System.out.println("  Contenido actual: [" + contenido + "]");
    }
}
