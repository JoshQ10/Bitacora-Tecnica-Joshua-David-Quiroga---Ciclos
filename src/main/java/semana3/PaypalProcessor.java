package semana3;

public class PaypalProcessor extends PaymentProcessor {

    @Override
    public Payment createPayment() {
        return new PaypalPayment();
    }
}
