package semana2.patrones.ejercicio1;

public class PushNotificacionFactory extends NotificacionFactory {
    @Override
    public Notificacion crearNotificacion() {
        return new PushNotificacion();
    }
}
