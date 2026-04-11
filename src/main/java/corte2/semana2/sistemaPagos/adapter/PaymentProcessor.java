package corte2.semana2.sistemaPagos.adapter;

import corte2.semana2.sistemaPagos.model.PaymentRequest;

/**
 * Interfaz comun del sistema interno.
 * Patron Adapter: todos los proveedores externos se adaptan a esta interfaz.
 */
public interface PaymentProcessor {
    boolean processPayment(PaymentRequest request);
    String getProviderName();
}
