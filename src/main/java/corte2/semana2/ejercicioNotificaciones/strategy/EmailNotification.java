package corte2.semana2.ejercicioNotificaciones.strategy;

public class EmailNotification implements NotificationStrategy {
    public void send(String message) {
        System.out.println("Email enviado: " + message);
    }
}
