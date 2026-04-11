package corte2.semana2.sistemaPagos.service;

import corte2.semana2.sistemaPagos.adapter.PaymentProcessor;
import corte2.semana2.sistemaPagos.chain.PaymentHandler;
import corte2.semana2.sistemaPagos.model.PaymentRequest;

/**
 * Servicio principal de pagos.
 * Orquesta la cadena de validaciones y delega el procesamiento al proveedor seleccionado.
 *
 * Patron Strategy (via Adapter): el proveedor puede cambiarse en tiempo de ejecucion.
 * Patron Chain of Responsibility: las validaciones se ejecutan en cadena antes del pago.
 */
public class PaymentService {

    private PaymentProcessor processor;
    private PaymentHandler validationChain;

    public PaymentService(PaymentProcessor processor, PaymentHandler validationChain) {
        this.processor = processor;
        this.validationChain = validationChain;
    }

    public void setProcessor(PaymentProcessor processor) {
        this.processor = processor;
    }

    public boolean processPayment(PaymentRequest request) {
        System.out.println("\n--- Procesando pago con " + processor.getProviderName()
                + " | Usuario: " + request.getUserId()
                + " | Monto: $" + request.getAmount() + " ---");

        if (validationChain != null && !validationChain.handle(request)) {
            System.out.println(">> Pago RECHAZADO por validaciones.");
            return false;
        }

        boolean result = processor.processPayment(request);
        System.out.println(">> Pago " + (result ? "EXITOSO" : "FALLIDO") + ".");
        return result;
    }
}
