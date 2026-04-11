package corte2.semana2.ejercicioNotificaciones;

import corte2.semana2.ejercicioNotificaciones.service.NotificationService;
import corte2.semana2.ejercicioNotificaciones.strategy.EmailNotification;
import corte2.semana2.ejercicioNotificaciones.strategy.PushNotification;
import corte2.semana2.ejercicioNotificaciones.strategy.SMSNotification;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Sistema de Notificaciones ===");

        NotificationService service = NotificationService.getInstance();

        // Strategy: Email
        service.setStrategy(new EmailNotification());
        service.send("Bienvenido al sistema");

        // Strategy: SMS
        service.setStrategy(new SMSNotification());
        service.send("Codigo de verificacion: 1234");

        // Strategy: Push
        service.setStrategy(new PushNotification());
        service.send("Tienes una nueva notificacion");

        // Singleton: misma instancia
        NotificationService s1 = NotificationService.getInstance();
        NotificationService s2 = NotificationService.getInstance();
        System.out.println("Singleton verificado (misma instancia): " + (s1 == s2));
    }
}
