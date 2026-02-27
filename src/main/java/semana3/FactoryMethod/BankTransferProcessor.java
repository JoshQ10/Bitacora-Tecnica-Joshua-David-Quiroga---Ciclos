package semana3.FactoryMethod;

public class BankTransferProcessor extends PaymentProcessor {

    @Override
    public Payment createPayment() {
        return new BankTransferPayment();
    }
}
