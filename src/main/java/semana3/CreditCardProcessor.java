package semana3;

public class CreditCardProcessor extends PaymentProcessor {

    @Override
    public Payment createPayment() {
        return new CreditCardPayment();
    }
}
