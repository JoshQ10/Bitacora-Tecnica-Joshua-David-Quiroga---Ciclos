package semana2.patrones.ejercicio1;

public class PushNotificacion implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("  _________________________________________");
        System.out.println(" |  Mi App                          ahora  |");
        System.out.println(" |  " + mensaje);
        System.out.println(" |  Desliza para ver mas...                |");
        System.out.println(" |_________________________________________|");
        System.out.println("  Dispositivo: Samsung Galaxy S24");
        System.out.println("  Token FCM: dk39...x8f2\n");
    }
}
