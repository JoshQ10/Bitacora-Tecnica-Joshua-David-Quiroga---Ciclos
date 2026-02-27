package semana3.FactoryMethod;

public class CreditCardProcessor extends PaymentProcessor {

    @Override
    public Payment createPayment() {
        return new CreditCardPayment();
    }
}
