package semana3;

public class PaypalPayment implements Payment{

    @Override
    public void pay(double amount) {
        System.out.println("Pago con paypal por :" + amount);

    }
}
