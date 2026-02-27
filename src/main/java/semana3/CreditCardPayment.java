package semana3;

public class CreditCardPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Pago con tarjeta de credito por: " + amount);
    }

}
