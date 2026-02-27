package semana3;

public class BankTransferProcessor extends PaymentProcessor {

    @Override
    public Payment createPayment() {
        return new BankTransferPayment();
    }
}
