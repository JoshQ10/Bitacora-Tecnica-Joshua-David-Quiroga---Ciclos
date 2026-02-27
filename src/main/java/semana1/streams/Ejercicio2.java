package semana1.streams;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio2 {
    public static void main(String[] args) {

        List<String> words = List.of("Milk", "Clothes", "Mountain", "Blue", "Canada");

        List<String> newWords = words.stream()
                .filter(n -> n.length() > 4)
                .map(n -> n.toUpperCase())
                .sorted()
                .toList();

        System.out.println("La lista de palabras que cumple las condiciones es: " + newWords);

    }
}
