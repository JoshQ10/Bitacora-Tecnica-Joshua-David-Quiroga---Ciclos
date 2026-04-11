package corte2.semana2.sistemaPagos;

import corte2.semana2.sistemaPagos.adapter.*;
import corte2.semana2.sistemaPagos.chain.*;
import corte2.semana2.sistemaPagos.model.PaymentRequest;
import corte2.semana2.sistemaPagos.service.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    private PaymentHandler validationChain;

    @BeforeEach
    void setUp() {
        BalanceHandler balance = new BalanceHandler();
        FraudHandler fraud = new FraudHandler();
        LimitHandler limit = new LimitHandler();
        balance.setNext(fraud).setNext(limit);
        validationChain = balance;
    }

    // ---- Pruebas de Validaciones (Chain of Responsibility) ----

    @Test
    void testValidacion_saldoInsuficiente_rechazaPago() {
        PaymentService service = new PaymentService(new PayPalAdapter(), validationChain);
        PaymentRequest request = new PaymentRequest("user-01", 5000.0, 100.0);
        assertFalse(service.processPayment(request), "Debe rechazar cuando el saldo es insuficiente");
    }

    @Test
    void testValidacion_posibleFraude_rechazaPago() {
        PaymentService service = new PaymentService(new PayPalAdapter(), validationChain);
        // Monto mayor al umbral de fraude ($10,000)
        PaymentRequest request = new PaymentRequest("user-02", 12000.0, 50000.0);
        assertFalse(service.processPayment(request), "Debe rechazar montos sospechosos de fraude");
    }

    @Test
    void testValidacion_limiteExcedido_rechazaPago() {
        PaymentService service = new PaymentService(new PayPalAdapter(), validationChain);
        // Monto entre fraude (10k) y limite diario (5k): 7000 pasa fraude pero falla limite
        PaymentRequest request = new PaymentRequest("user-03", 7000.0, 20000.0);
        assertFalse(service.processPayment(request), "Debe rechazar cuando supera el limite diario");
    }

    @Test
    void testValidacion_pagoValido_aprueba() {
        PaymentService service = new PaymentService(new PayPalAdapter(), validationChain);
        PaymentRequest request = new PaymentRequest("user-04", 1500.0, 3000.0);
        assertTrue(service.processPayment(request), "Debe aprobar un pago dentro de todos los limites");
    }

    // ---- Pruebas de Adapters ----

    @Test
    void testAdapter_paypal_procesaCorrectamente() {
        PaymentService service = new PaymentService(new PayPalAdapter(), null);
        PaymentRequest request = new PaymentRequest("user-05", 200.0, 1000.0);
        assertTrue(service.processPayment(request));
        assertEquals("PayPal", new PayPalAdapter().getProviderName());
    }

    @Test
    void testAdapter_stripe_procesaCorrectamente() {
        PaymentService service = new PaymentService(new StripeAdapter(), null);
        PaymentRequest request = new PaymentRequest("user-06", 300.0, 1000.0);
        assertTrue(service.processPayment(request));
        assertEquals("Stripe", new StripeAdapter().getProviderName());
    }

    @Test
    void testAdapter_creditCard_procesaCorrectamente() {
        PaymentService service = new PaymentService(new CreditCardAdapter("4111-1111-1111-1111"), null);
        PaymentRequest request = new PaymentRequest("user-07", 150.0, 500.0);
        assertTrue(service.processPayment(request));
        assertEquals("CreditCard", new CreditCardAdapter("0000").getProviderName());
    }

    @Test
    void testAdapter_bankTransfer_procesaCorrectamente() {
        PaymentService service = new PaymentService(new BankTransferAdapter("ACC-DEST"), null);
        PaymentRequest request = new PaymentRequest("user-08", 400.0, 2000.0);
        assertTrue(service.processPayment(request));
        assertEquals("BankTransfer", new BankTransferAdapter("x").getProviderName());
    }

    // ---- Prueba de cambio de proveedor (Strategy via Adapter) ----

    @Test
    void testCambioDinamicoDeProveedor() {
        PaymentService service = new PaymentService(new PayPalAdapter(), null);
        PaymentRequest request = new PaymentRequest("user-09", 100.0, 500.0);

        assertTrue(service.processPayment(request));

        service.setProcessor(new StripeAdapter());
        assertTrue(service.processPayment(request));
    }
}
