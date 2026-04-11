package corte2.semana2.sistemaPagos.adapter.external;

/**
 * API externa de PayPal (interfaz incompatible con el sistema interno).
 */
public class PayPalAPI {

    public void makePayment(String userId, double amount) {
        System.out.println("[PayPal API] Pago enviado - Usuario: " + userId + " | Monto: $" + amount);
    }
}
