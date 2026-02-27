package semana3.FactoryMethod;

public class PaypalPayment implements Payment{

    @Override
    public void pay(double amount) {
        System.out.println("Pago con paypal por :" + amount);

    }
}
