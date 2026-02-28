package semana2.patrones.ejercicio2;

public class ImpresoraBasica implements Impresora {
    @Override
    public void imprimir(String texto) {
        System.out.println(">> " + texto);
    }
}
