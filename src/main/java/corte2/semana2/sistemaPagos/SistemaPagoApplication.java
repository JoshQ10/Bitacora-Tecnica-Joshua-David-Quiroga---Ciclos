package corte2.semana2.sistemaPagos;

import corte2.semana2.sistemaPagos.adapter.*;
import corte2.semana2.sistemaPagos.chain.*;
import corte2.semana2.sistemaPagos.model.PaymentRequest;
import corte2.semana2.sistemaPagos.service.PaymentService;

public class SistemaPagoApplication {

    public static void main(String[] args) {
        System.out.println("=== Sistema de Procesamiento de Pagos ===\n");

        // Construir cadena de validaciones: Saldo -> Fraude -> Limite
        BalanceHandler balance = new BalanceHandler();
        FraudHandler fraud = new FraudHandler();
        LimitHandler limit = new LimitHandler();
        balance.setNext(fraud).setNext(limit);

        // --- Caso 1: Pago exitoso con PayPal ---
        PaymentService service = new PaymentService(new PayPalAdapter(), balance);
        PaymentRequest ok = new PaymentRequest("user-01", 1500.0, 3000.0);
        service.processPayment(ok);

        // --- Caso 2: Saldo insuficiente ---
        PaymentRequest sinSaldo = new PaymentRequest("user-02", 5000.0, 100.0);
        service.processPayment(sinSaldo);

        // --- Caso 3: Cambio de proveedor a Stripe ---
        service.setProcessor(new StripeAdapter());
        PaymentRequest stripeOk = new PaymentRequest("user-03", 2000.0, 5000.0);
        service.processPayment(stripeOk);

        // --- Caso 4: Pago con Tarjeta de Credito ---
        service.setProcessor(new CreditCardAdapter("4111-1111-1111-1111"));
        PaymentRequest creditCard = new PaymentRequest("user-04", 300.0, 1000.0);
        service.processPayment(creditCard);

        // --- Caso 5: Transferencia bancaria ---
        service.setProcessor(new BankTransferAdapter("ACC-9999"));
        PaymentRequest transfer = new PaymentRequest("user-05", 800.0, 2000.0);
        service.processPayment(transfer);

        // --- Caso 6: Monto sospechoso (fraude) ---
        service.setProcessor(new PayPalAdapter());
        PaymentRequest fraude = new PaymentRequest("user-06", 15000.0, 50000.0);
        service.processPayment(fraude);
    }
}
