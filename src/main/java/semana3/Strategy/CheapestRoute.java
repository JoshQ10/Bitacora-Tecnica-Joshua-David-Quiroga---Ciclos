package semana3.Strategy;

public class CheapestRoute implements RouteStrategy {
    @Override
    public void calculateRoute() {
        System.out.println("Calculando la ruta MÁS ECONÓMICA...");
        System.out.println("→ Evitando peajes y autopistas de pago");
        System.out.println("→ Tiempo estimado: 40 minutos\n");
    }
}
