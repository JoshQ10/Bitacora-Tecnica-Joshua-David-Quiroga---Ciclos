package semana3.Composite;

public class Producto implements ItemBodega {

    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public void mostrar(String indentacion) {
        System.out.println(indentacion + "Producto: " + nombre + " - $" + precio);
    }
}
