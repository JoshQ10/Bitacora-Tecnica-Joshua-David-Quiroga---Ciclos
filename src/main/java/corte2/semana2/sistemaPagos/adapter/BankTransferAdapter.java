package corte2.semana2.sistemaPagos.adapter;

import corte2.semana2.sistemaPagos.adapter.external.BankTransferAPI;
import corte2.semana2.sistemaPagos.model.PaymentRequest;

/**
 * Adapter: adapta BankTransferAPI a la interfaz PaymentProcessor del sistema interno.
 */
public class BankTransferAdapter implements PaymentProcessor {

    private final BankTransferAPI bankTransferAPI;
    private final String destinationAccount;

    public BankTransferAdapter(String destinationAccount) {
        this.bankTransferAPI = new BankTransferAPI();
        this.destinationAccount = destinationAccount;
    }

    @Override
    public boolean processPayment(PaymentRequest request) {
        bankTransferAPI.transfer(request.getUserId(), destinationAccount, request.getAmount());
        return true;
    }

    @Override
    public String getProviderName() {
        return "BankTransfer";
    }
}
