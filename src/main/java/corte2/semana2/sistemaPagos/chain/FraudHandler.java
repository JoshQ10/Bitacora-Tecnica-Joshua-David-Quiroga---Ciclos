package corte2.semana2.sistemaPagos.chain;

import corte2.semana2.sistemaPagos.model.PaymentRequest;

/**
 * Validador anti-fraude: detecta montos sospechosamente altos.
 */
public class FraudHandler extends PaymentHandler {

    private static final double FRAUD_THRESHOLD = 10_000.0;

    @Override
    public boolean handle(PaymentRequest request) {
        if (request.getAmount() > FRAUD_THRESHOLD) {
            System.out.println("[Validacion] FALLO - Posible fraude detectado. "
                    + "Monto $" + request.getAmount() + " supera el umbral de $" + FRAUD_THRESHOLD);
            return false;
        }
        System.out.println("[Validacion] OK - Sin indicios de fraude");
        return passToNext(request);
    }
}
