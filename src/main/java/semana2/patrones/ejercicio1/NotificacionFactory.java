package semana2.patrones.ejercicio1;

public abstract class NotificacionFactory {

    // 🔑 FACTORY METHOD - las subclases deciden qué objeto crear
    public abstract Notificacion crearNotificacion();

    // Método que usa el factory method (no sabe qué tipo concreto se crea)
    public void notificar(String mensaje) {
        Notificacion notificacion = crearNotificacion();
        notificacion.enviar(mensaje);
    }
}
