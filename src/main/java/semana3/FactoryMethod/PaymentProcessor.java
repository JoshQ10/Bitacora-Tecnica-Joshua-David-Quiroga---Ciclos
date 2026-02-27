package semana3.FactoryMethod;

public abstract class PaymentProcessor {

    public abstract Payment createPayment();

    public void processPayment(double amount) {
        Payment payment = createPayment();
        payment.pay(amount);
    }
}
