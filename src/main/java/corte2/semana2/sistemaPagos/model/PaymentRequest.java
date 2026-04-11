package corte2.semana2.sistemaPagos.model;

public class PaymentRequest {

    private String userId;
    private double amount;
    private double balance;

    public PaymentRequest(String userId, double amount, double balance) {
        this.userId = userId;
        this.amount = amount;
        this.balance = balance;
    }

    public String getUserId() { return userId; }
    public double getAmount() { return amount; }
    public double getBalance() { return balance; }
}
