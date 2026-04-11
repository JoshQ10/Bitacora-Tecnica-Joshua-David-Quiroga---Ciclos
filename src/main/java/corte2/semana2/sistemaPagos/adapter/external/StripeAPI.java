package corte2.semana2.sistemaPagos.adapter.external;

/**
 * API externa de Stripe (interfaz incompatible con el sistema interno).
 * Recibe el monto en centavos y retorna un código de transacción.
 */
public class StripeAPI {

    public String charge(long amountInCents, String customerId) {
        System.out.println("[Stripe API] Cargo realizado - Cliente: " + customerId
                + " | Monto (centavos): " + amountInCents);
        return "txn_" + System.currentTimeMillis();
    }
}
