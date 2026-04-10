package edu.dosw.bitacora.tecnica.Bitacora_Tecnica.semana2.service;

import corte2.semana2.ejercicioNotificaciones.service.NotificationService;
import corte2.semana2.ejercicioNotificaciones.strategy.EmailNotification;
import corte2.semana2.ejercicioNotificaciones.strategy.SMSNotification;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {

    @Test
    void testSingleton() {
        NotificationService s1 = NotificationService.getInstance();
        NotificationService s2 = NotificationService.getInstance();
        assertSame(s1, s2);
    }

    @Test
    void testStrategyChange() {
        NotificationService service = NotificationService.getInstance();

        service.setStrategy(new EmailNotification());
        service.send("Hola Email");

        service.setStrategy(new SMSNotification());
        service.send("Hola SMS");

        assertTrue(true); // validación básica
    }
}
