package semana1.streams.Ejercicio3y4;
import java.util.List;

public class Ejercicio4 {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User(1, "Juan", 17, true),
                new User(2, "Pedro", 20, true),
                new User(3, "Sara", 15, false),
                new User(4, "Eduardo", 25, true)
        );

        List<String> mayoresDeEdad = users.stream()
                .filter(user -> user.getAge() >= 18)   // Filtrar mayores
                .map(User::getName)                   // Obtener nombres
                .toList();                            // Convertir a lista

        System.out.println("Los usuarios mayores de edad son: " + mayoresDeEdad);
    }
}

