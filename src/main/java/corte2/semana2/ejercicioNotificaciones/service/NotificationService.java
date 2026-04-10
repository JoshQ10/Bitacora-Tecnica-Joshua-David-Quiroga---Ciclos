package corte2.semana2.ejercicioNotificaciones.service;
import corte2.semana2.ejercicioNotificaciones.strategy.NotificationStrategy;

public class NotificationService {

    private static NotificationService instance;
    private NotificationStrategy strategy;

    private NotificationService() {}

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void send(String message) {
        strategy.send(message);
    }
}
