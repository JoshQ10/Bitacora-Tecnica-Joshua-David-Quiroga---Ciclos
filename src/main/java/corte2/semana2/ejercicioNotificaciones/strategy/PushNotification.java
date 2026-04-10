package corte2.semana2.ejercicioNotificaciones.strategy;

public class PushNotification implements NotificationStrategy {
    public void send(String message) {
        System.out.println("Push enviado: " + message);
    }
}
