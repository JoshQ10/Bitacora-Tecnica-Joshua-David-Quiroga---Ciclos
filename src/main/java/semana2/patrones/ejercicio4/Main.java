package semana2.patrones.ejercicio4;

public class Main {
    public static void main(String[] args) {

        Calculadora calc = new Calculadora();

        // Instalando operaciones
        System.out.println("--- Configurando calculadora ---");
        calc.instalar(new Suma());
        calc.instalar(new Resta());
        calc.instalar(new Multiplicacion());
        calc.instalar(new Division());
        System.out.println();

        // Mostrar operaciones disponibles
        calc.verOperaciones();
        System.out.println();

        // Operaciones con enteros
        System.out.println("--- Operaciones con enteros ---");
        calc.ejecutar("+", 15, 8);
        calc.ejecutar("-", 20, 7);
        calc.ejecutar("*", 6, 4);
        calc.ejecutar("/", 30, 5);
        System.out.println();

        // Operaciones con decimales
        System.out.println("--- Operaciones con decimales ---");
        calc.ejecutar("+", 3.5, 2.1);
        calc.ejecutar("-", 10.8, 4.3);
        calc.ejecutar("*", 2.5, 3.0);
        calc.ejecutar("/", 7.5, 2.5);
        System.out.println();

        // Division entre cero
        System.out.println("--- Caso especial ---");
        calc.ejecutar("/", 10, 0);
        System.out.println();

        // Operacion no instalada
        System.out.println("--- Operacion desconocida ---");
        calc.ejecutar("%", 10, 3);
    }
}
