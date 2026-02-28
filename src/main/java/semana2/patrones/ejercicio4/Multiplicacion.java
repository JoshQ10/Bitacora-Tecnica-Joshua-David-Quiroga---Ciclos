package semana2.patrones.ejercicio4;

public class Multiplicacion implements Operacion {
    @Override
    public String getSimbolo() {
        return "*";
    }

    @Override
    public double calcular(double a, double b) {
        return a * b;
    }
}
