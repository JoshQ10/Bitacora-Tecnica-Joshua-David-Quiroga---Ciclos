package corte2.semana2.sistemaPagos.chain;

import corte2.semana2.sistemaPagos.model.PaymentRequest;

/**
 * Validador de límite de transacción: verifica que el monto no exceda el límite diario.
 */
public class LimitHandler extends PaymentHandler {

    private static final double DAILY_LIMIT = 5_000.0;

    @Override
    public boolean handle(PaymentRequest request) {
        if (request.getAmount() > DAILY_LIMIT) {
            System.out.println("[Validacion] FALLO - Limite de transaccion excedido. "
                    + "Monto $" + request.getAmount() + " supera el limite diario de $" + DAILY_LIMIT);
            return false;
        }
        System.out.println("[Validacion] OK - Dentro del limite de transaccion");
        return passToNext(request);
    }
}
