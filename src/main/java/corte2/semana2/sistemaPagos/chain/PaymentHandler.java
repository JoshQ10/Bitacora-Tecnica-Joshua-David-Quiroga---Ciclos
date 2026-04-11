package corte2.semana2.sistemaPagos.chain;

import corte2.semana2.sistemaPagos.model.PaymentRequest;

/**
 * Handler abstracto de la cadena de responsabilidad.
 * Cada eslabón decide si el pago continua o se detiene.
 */
public abstract class PaymentHandler {

    private PaymentHandler next;

    /**
     * Encadena el siguiente handler. Retorna el siguiente para permitir
     * construcción fluida: balance.setNext(fraud).setNext(limit)
     */
    public PaymentHandler setNext(PaymentHandler next) {
        this.next = next;
        return next;
    }

    public abstract boolean handle(PaymentRequest request);

    protected boolean passToNext(PaymentRequest request) {
        if (next != null) {
            return next.handle(request);
        }
        return true;
    }
}
