package corte2.semana2.sistemaPagos.adapter;

import corte2.semana2.sistemaPagos.adapter.external.StripeAPI;
import corte2.semana2.sistemaPagos.model.PaymentRequest;

/**
 * Adapter: adapta StripeAPI a la interfaz PaymentProcessor del sistema interno.
 * Stripe trabaja en centavos, por lo que se convierte el monto.
 */
public class StripeAdapter implements PaymentProcessor {

    private final StripeAPI stripeAPI;

    public StripeAdapter() {
        this.stripeAPI = new StripeAPI();
    }

    @Override
    public boolean processPayment(PaymentRequest request) {
        long amountInCents = (long)(request.getAmount() * 100);
        String txn = stripeAPI.charge(amountInCents, request.getUserId());
        return txn != null && !txn.isEmpty();
    }

    @Override
    public String getProviderName() {
        return "Stripe";
    }
}
