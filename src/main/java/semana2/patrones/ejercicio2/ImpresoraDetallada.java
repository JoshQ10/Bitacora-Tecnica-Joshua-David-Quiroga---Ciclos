package semana2.patrones.ejercicio2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ImpresoraDetallada {

    public void imprimirConDetalle(String texto, String autor, String fecha) {
        System.out.println(".-------------------------------------------.");
        System.out.println("|  DOCUMENTO REGISTRADO                     |");
        System.out.println("|-------------------------------------------|");
        System.out.println("|  Contenido : " + texto);
        System.out.println("|  Redactado : " + autor);
        System.out.println("|  Emitido   : " + fecha);
        System.out.println("'-------------------------------------------'\n");
    }
}
