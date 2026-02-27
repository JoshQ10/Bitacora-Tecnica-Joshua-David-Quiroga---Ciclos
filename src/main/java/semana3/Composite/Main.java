package semana3.Composite;

public class Main {

    public static void main(String[] args) {

        // Productos individuales
        Producto laptop = new Producto("Laptop", 1000.00);
        Producto mouse = new Producto("Mouse", 25.00);
        Producto teclado = new Producto("Teclado", 50.00);
        Producto monitor = new Producto("Monitor", 500.00);
        Producto cable = new Producto("Cable HDMI", 15.00);
        Producto adaptador = new Producto("Adaptador USB", 10.00);

        // Caja pequeña (contiene productos)
        Caja cajaPequena = new Caja("Caja Pequeña");
        cajaPequena.agregar(cable);
        cajaPequena.agregar(adaptador);

        // Caja mediana (contiene productos)
        Caja cajaMediana = new Caja("Caja Mediana");
        cajaMediana.agregar(mouse);
        cajaMediana.agregar(teclado);

        // Caja grande (contiene productos Y otras cajas)
        Caja cajaGrande = new Caja("Caja Grande");
        cajaGrande.agregar(laptop);
        cajaGrande.agregar(monitor);
        cajaGrande.agregar(cajaMediana);     // caja dentro de caja
        cajaGrande.agregar(cajaPequena);     // caja dentro de caja

        // El sistema trata TODO igual
        System.out.println("=== Precio de un producto individual ===");
        System.out.println("Precio: $" + laptop.getPrecio());

        System.out.println();

        System.out.println("=== Precio de la caja mediana ===");
        System.out.println("Precio: $" + cajaMediana.getPrecio());

        System.out.println();

        System.out.println("=== Precio de la caja grande (todo) ===");
        System.out.println("Precio: $" + cajaGrande.getPrecio());

        System.out.println();

        System.out.println("=== Estructura completa ===");
        cajaGrande.mostrar("");
    }
}
