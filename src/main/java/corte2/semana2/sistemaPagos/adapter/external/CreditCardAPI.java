package corte2.semana2.sistemaPagos.adapter.external;

/**
 * API externa de Tarjeta de Credito (interfaz incompatible con el sistema interno).
 * Requiere numero de tarjeta y total; devuelve un código de autorización.
 */
public class CreditCardAPI {

    public String processCard(String cardNumber, double total) {
        System.out.println("[Credit Card API] Procesando tarjeta: " + cardNumber
                + " | Total: $" + total);
        return "AUTH-" + (int)(Math.random() * 100000);
    }
}
