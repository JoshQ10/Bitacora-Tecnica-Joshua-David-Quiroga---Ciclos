package semana2.patrones.ejercicio2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdaptadorImpresora implements Impresora {

    private ImpresoraDetallada impresoraDetallada;
    private String autor;

    public AdaptadorImpresora(ImpresoraDetallada impresoraDetallada, String autor) {
        this.impresoraDetallada = impresoraDetallada;
        this.autor = autor;
    }

    @Override
    public void imprimir(String texto) {
        // Genera la fecha actual automaticamente para completar lo que pide la Clase B
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        String fechaActual = LocalDateTime.now().format(formato);

        // Delega el trabajo a la impresora detallada
        impresoraDetallada.imprimirConDetalle(texto, autor, fechaActual);
    }
}
