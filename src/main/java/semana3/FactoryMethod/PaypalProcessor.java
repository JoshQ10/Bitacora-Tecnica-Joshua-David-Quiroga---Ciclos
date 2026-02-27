package semana3.FactoryMethod;

public class PaypalProcessor extends PaymentProcessor {

    @Override
    public Payment createPayment() {
        return new PaypalPayment();
    }
}
