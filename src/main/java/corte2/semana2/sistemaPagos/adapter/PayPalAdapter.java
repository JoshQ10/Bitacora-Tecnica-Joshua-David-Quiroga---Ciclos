package corte2.semana2.sistemaPagos.adapter;

import corte2.semana2.sistemaPagos.adapter.external.PayPalAPI;
import corte2.semana2.sistemaPagos.model.PaymentRequest;

/**
 * Adapter: adapta PayPalAPI a la interfaz PaymentProcessor del sistema interno.
 */
public class PayPalAdapter implements PaymentProcessor {

    private final PayPalAPI payPalAPI;

    public PayPalAdapter() {
        this.payPalAPI = new PayPalAPI();
    }

    @Override
    public boolean processPayment(PaymentRequest request) {
        payPalAPI.makePayment(request.getUserId(), request.getAmount());
        return true;
    }

    @Override
    public String getProviderName() {
        return "PayPal";
    }
}
