import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        // Tworzenie przykładowych użytkowników forum
        Forum forum = new Forum();
        forum.addUser(new ForumUser(1, "John", 'M', LocalDate.of(1990, 5, 15), 10));
        forum.addUser(new ForumUser(2, "Alice", 'F', LocalDate.of(1985, 8, 22), 5));
        forum.addUser(new ForumUser(3, "Bob", 'M', LocalDate.of(2000, 3, 10), 25));
        forum.addUser(new ForumUser(4, "Emma", 'F', LocalDate.of(1992, 12, 5), 0));

        // Filtracja i tworzenie mapy
        Map<Integer, ForumUser> resultMap = forum.getUserList().stream()
                .filter(user -> user.getGender() == 'M')
                .filter(user -> user.getBirthDate().plusYears(20).isBefore(LocalDate.now()))
                .filter(user -> user.getPostCount() > 0)
                .collect(Collectors.toMap(ForumUser::getUserId, user -> user));

        // Wyświetlanie otrzymanej mapy wynikowej
        resultMap.forEach((id, user) -> System.out.println("User ID: " + id + ", Username: " + user.getUsername()));
    }
}
