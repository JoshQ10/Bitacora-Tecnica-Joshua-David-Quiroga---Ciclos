package semana2.patrones.ejercicio1;

public class Main {
    public static void main(String[] args) {

        // El main NO conoce las clases concretas de Notificacion
        // Solo trabaja con la fábrica abstracta

        NotificacionFactory emailFactory = new EmailNotificacionFactory();
        emailFactory.notificar("Su pedido ha sido confirmado.");

        NotificacionFactory smsFactory = new SMSNotificacionFactory();
        smsFactory.notificar("Código de verificación: 482913");

        NotificacionFactory pushFactory = new PushNotificacionFactory();
        pushFactory.notificar("Tienes 3 mensajes nuevos.");
    }
}
