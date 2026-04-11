package corte2.semana2.sistemaPagos.adapter.external;

/**
 * API externa de Transferencia Bancaria (interfaz incompatible con el sistema interno).
 * Opera con cuentas origen/destino y monto.
 */
public class BankTransferAPI {

    public void transfer(String fromAccount, String toAccount, double amount) {
        System.out.println("[Bank Transfer API] Transferencia de $" + amount
                + " | Origen: " + fromAccount + " -> Destino: " + toAccount);
    }
}
