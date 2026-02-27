package semana3.Composite;

import java.util.ArrayList;
import java.util.List;

public class Caja implements ItemBodega {

    private String nombre;
    private List<ItemBodega> items = new ArrayList<>();

    public Caja(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(ItemBodega item) {
        items.add(item);
    }

    public void remover(ItemBodega item) {
        items.remove(item);
    }

    @Override
    public double getPrecio() {
        double total = 0;
        for (ItemBodega item : items) {
            total += item.getPrecio();  // ← RECURSIÓN: puede ser Producto o Caja
        }
        return total;
    }

    @Override
    public void mostrar(String indentacion) {
        System.out.println(indentacion + "Caja: " + nombre + " - Precio total: $" + getPrecio());
        for (ItemBodega item : items) {
            item.mostrar(indentacion + "   ");  // ← RECURSIÓN
        }
    }
}
