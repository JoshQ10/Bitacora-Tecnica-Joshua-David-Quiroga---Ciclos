package semana2.patrones.ejercicio4;

public class Division implements Operacion {
    @Override
    public String getSimbolo() {
        return "/";
    }

    @Override
    public double calcular(double a, double b) {
        if (b == 0) {
            System.out.println("  Error: No se puede dividir entre cero.");
            return 0;
        }
        return a / b;
    }
}
