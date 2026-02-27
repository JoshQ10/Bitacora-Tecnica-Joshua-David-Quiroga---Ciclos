package semana3.Strategy;

public class FastestRoute implements RouteStrategy {
    @Override
    public void calculateRoute() {
        System.out.println("Calculando la ruta MÁS RÁPIDA...");
        System.out.println("→ Usando autopistas y vías principales");
        System.out.println("→ Tiempo estimado: 25 minutos\n");
    }
}
