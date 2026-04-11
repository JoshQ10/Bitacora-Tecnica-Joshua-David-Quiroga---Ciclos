package corte2.semana2.sistemaPagos.adapter;

import corte2.semana2.sistemaPagos.adapter.external.CreditCardAPI;
import corte2.semana2.sistemaPagos.model.PaymentRequest;

/**
 * Adapter: adapta CreditCardAPI a la interfaz PaymentProcessor del sistema interno.
 */
public class CreditCardAdapter implements PaymentProcessor {

    private final CreditCardAPI creditCardAPI;
    private final String cardNumber;

    public CreditCardAdapter(String cardNumber) {
        this.creditCardAPI = new CreditCardAPI();
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean processPayment(PaymentRequest request) {
        String authCode = creditCardAPI.processCard(cardNumber, request.getAmount());
        return authCode != null && authCode.startsWith("AUTH");
    }

    @Override
    public String getProviderName() {
        return "CreditCard";
    }
}
