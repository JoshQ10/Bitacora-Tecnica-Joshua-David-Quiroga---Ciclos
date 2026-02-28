package semana2.patrones.ejercicio1;

public class SMSNotificacion implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("+------------------------------------------+");
        System.out.println("|  OPERADORA: Claro Movil                  |");
        System.out.println("|  DESTINO: +503 7890-1234                 |");
        System.out.println("|  CONTENIDO: " + mensaje);
        System.out.println("|  CARACTERES: " + mensaje.length() + "/160");
        System.out.println("|  ESTADO: Entregado                       |");
        System.out.println("+------------------------------------------+\n");
    }
}
