package semana1.streams.Ejercicio3y4;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<User> usuarios = List.of(
                new User(1, "Juan", 25, true),
                new User(2, "Pedro", 30, false),
                new User(3, "Sara", 22, true),
                new User(4, "Eduardo", 28, true)
        );

        List<String> nombresActivos = usuarios.stream()
                .filter(User::isActive)           // Solo activos
                .map(usuario -> usuario.getName())  // Obtener nombre
                .map(String::toUpperCase)           // Mayúsculas
                .sorted()                           // Orden alfabético
                .toList();                          // Convertir a lista

        System.out.println("Los usuarios activos son: " + nombresActivos);
    }
}

