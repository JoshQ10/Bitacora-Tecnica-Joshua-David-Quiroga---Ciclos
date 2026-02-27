package semana1.streams.Ejercicio5;

public class Transaction {

    private String id;
    private double amount;
    private boolean approved;

    public Transaction(String id, double amount, boolean approved) {
        this.id = id;
        this.amount = amount;
        this.approved = approved;
    }

    public boolean isApproved() {
        return approved;
    }

    @Override
    public String toString() {
        return "Transaction{id='" + id + "', amount=" + amount + ", approved=" + approved + "}";
    }
}

