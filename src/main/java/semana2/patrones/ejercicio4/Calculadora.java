package semana2.patrones.ejercicio4;

import java.util.LinkedHashMap;
import java.util.Map;

public class Calculadora {
    private Map<String, Operacion> operaciones;

    public Calculadora() {
        this.operaciones = new LinkedHashMap<>();
    }

    // Se "instalan" operaciones sin modificar esta clase
    public void instalar(Operacion operacion) {
        operaciones.put(operacion.getSimbolo(), operacion);
        System.out.println("  Operacion [" + operacion.getSimbolo() + "] instalada.");
    }

    public void ejecutar(String simbolo, double a, double b) {
        Operacion op = operaciones.get(simbolo);

        if (op == null) {
            System.out.println("  Operacion '" + simbolo + "' no reconocida.\n");
            return;
        }

        double resultado = op.calcular(a, b);

        // Detectar si son enteros para mostrar sin decimales
        String valorA = esEntero(a) ? String.valueOf((int) a) : String.valueOf(a);
        String valorB = esEntero(b) ? String.valueOf((int) b) : String.valueOf(b);
        String valorR = esEntero(resultado) ? String.valueOf((int) resultado) : String.valueOf(resultado);

        System.out.println("  " + valorA + " " + simbolo + " " + valorB + " = " + valorR);
    }

    public void verOperaciones() {
        System.out.print("  Operaciones disponibles: ");
        for (String simbolo : operaciones.keySet()) {
            System.out.print("[ " + simbolo + " ] ");
        }
        System.out.println();
    }

    private boolean esEntero(double valor) {
        return valor == Math.floor(valor) && !Double.isInfinite(valor);
    }
}
