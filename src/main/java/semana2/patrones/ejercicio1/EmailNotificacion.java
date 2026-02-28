package semana2.patrones.ejercicio1;

public class EmailNotificacion implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("--------------------------------------------");
        System.out.println("  De: sistema@notificaciones.com");
        System.out.println("  Para: usuario@correo.com");
        System.out.println("  Asunto: Nueva notificacion");
        System.out.println("  Cuerpo: " + mensaje);
        System.out.println("  Estado: Enviado via servidor SMTP");
        System.out.println("--------------------------------------------\n");
    }
}
