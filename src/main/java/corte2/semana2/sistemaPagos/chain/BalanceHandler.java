package corte2.semana2.sistemaPagos.chain;

import corte2.semana2.sistemaPagos.model.PaymentRequest;

/**
 * Validador de saldo: verifica que el usuario tenga fondos suficientes.
 */
public class BalanceHandler extends PaymentHandler {

    @Override
    public boolean handle(PaymentRequest request) {
        if (request.getBalance() < request.getAmount()) {
            System.out.println("[Validacion] FALLO - Saldo insuficiente. "
                    + "Saldo: $" + request.getBalance()
                    + " | Monto requerido: $" + request.getAmount());
            return false;
        }
        System.out.println("[Validacion] OK - Saldo suficiente");
        return passToNext(request);
    }
}
