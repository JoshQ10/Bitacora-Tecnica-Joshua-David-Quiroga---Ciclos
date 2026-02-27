package semana3.Strategy;

public class ScenicRoute implements RouteStrategy {
    @Override
    public void calculateRoute() {
        System.out.println("Calculando la ruta PANORÁMICA...");
        System.out.println("→ Pasando por paisajes y puntos turísticos");
        System.out.println("→ Tiempo estimado: 55 minutos\n");
    }
}
