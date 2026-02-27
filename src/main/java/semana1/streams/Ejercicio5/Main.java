package semana1.streams.Ejercicio5;

import java.util.List;

public class Main {

    public static boolean isBatchValid(List<Transaction> transactions) {

        boolean hasUnapproved = transactions.stream()
                .peek(System.out::println)              // Print each transaction
                .anyMatch(t -> !t.isApproved());        // Check if any is NOT approved

        return !hasUnapproved; // If there is one unapproved → batch is invalid
    }

    public static void main(String[] args) {

        List<Transaction> transactions = List.of(
                new Transaction("T1", 200.0, true),
                new Transaction("T2", 500.0, true),
                new Transaction("T3", 100.0, false)
        );

        boolean isValid = isBatchValid(transactions);

        System.out.println("Is batch valid? " + isValid);
    }
}

