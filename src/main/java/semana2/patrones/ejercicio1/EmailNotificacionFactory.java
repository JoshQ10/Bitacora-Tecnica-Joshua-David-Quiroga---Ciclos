package semana2.patrones.ejercicio1;

public class EmailNotificacionFactory extends NotificacionFactory {
    @Override
    public Notificacion crearNotificacion() {
        return new EmailNotificacion();
    }
}
