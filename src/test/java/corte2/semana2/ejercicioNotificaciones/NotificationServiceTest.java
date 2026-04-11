package corte2.semana2.ejercicioNotificaciones;

import corte2.semana2.ejercicioNotificaciones.service.NotificationService;
import corte2.semana2.ejercicioNotificaciones.strategy.EmailNotification;
import corte2.semana2.ejercicioNotificaciones.strategy.PushNotification;
import corte2.semana2.ejercicioNotificaciones.strategy.SMSNotification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private NotificationService service;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
        service = NotificationService.getInstance();
    }

    @Test
    void testSingleton_mismaInstancia() {
        NotificationService s1 = NotificationService.getInstance();
        NotificationService s2 = NotificationService.getInstance();
        assertSame(s1, s2, "El Singleton debe retornar siempre la misma instancia");
    }

    @Test
    void testStrategy_email() {
        service.setStrategy(new EmailNotification());
        service.send("Test Email");
        assertTrue(output.toString().contains("Email enviado: Test Email"));
    }

    @Test
    void testStrategy_sms() {
        service.setStrategy(new SMSNotification());
        service.send("Test SMS");
        assertTrue(output.toString().contains("SMS enviado: Test SMS"));
    }

    @Test
    void testStrategy_push() {
        service.setStrategy(new PushNotification());
        service.send("Test Push");
        assertTrue(output.toString().contains("Push enviado: Test Push"));
    }

    @Test
    void testStrategy_cambioDinamico() {
        service.setStrategy(new EmailNotification());
        service.send("Primer mensaje");

        service.setStrategy(new SMSNotification());
        service.send("Segundo mensaje");

        String salida = output.toString();
        assertTrue(salida.contains("Email enviado: Primer mensaje"));
        assertTrue(salida.contains("SMS enviado: Segundo mensaje"));
    }
}
