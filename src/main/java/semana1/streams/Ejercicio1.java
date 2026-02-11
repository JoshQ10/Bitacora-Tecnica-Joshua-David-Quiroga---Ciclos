package semana1.streams;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio1 {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(3, 8, 6, 9, 12, 16, 17);

        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .filter(n -> n > 10)
                .collect(Collectors.toList());

        System.out.println("Given LIST: " + numbers);
        System.out.println("New List: " + result);

    }
}
