package corte2.semana2.ejercicioNotificaciones.strategy;

public class SMSNotification implements NotificationStrategy {
    public void send(String message) {
        System.out.println("SMS enviado: " + message);
    }
}
