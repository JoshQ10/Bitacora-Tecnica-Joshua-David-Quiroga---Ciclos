package semana2.patrones.ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Historial {
    private List<Respaldo> respaldos;

    public Historial() {
        this.respaldos = new ArrayList<>();
    }

    public void guardar(Respaldo respaldo) {
        respaldos.add(respaldo);
    }

    public Respaldo recuperar() {
        if (respaldos.isEmpty()) {
            System.out.println("  No hay estados anteriores para restaurar.");
            return null;
        }
        // Saca el ultimo respaldo guardado
        return respaldos.remove(respaldos.size() - 1);
    }

    public int verTamanio() {
        return respaldos.size();
    }
}
