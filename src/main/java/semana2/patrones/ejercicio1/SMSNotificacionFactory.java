package semana2.patrones.ejercicio1;

public class SMSNotificacionFactory extends NotificacionFactory {
    @Override
    public Notificacion crearNotificacion() {
        return new SMSNotificacion();
    }
}
