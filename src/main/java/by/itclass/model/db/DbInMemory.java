package by.itclass.model.db;

import by.itclass.model.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DbInMemory {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Vasya Pupkin", "vasya@gmail.com"));
        users.add(new User(2, "Petya Pupkin", "petya@gmail.com"));
        users.add(new User(3, "Nikita Pupkin", "nikita@mail.ru"));
    }

    public static boolean isUserExistByName(String name) {
        return users.stream()
                .anyMatch(user -> user.getName().equalsIgnoreCase(name));
    }

    public static User findUserByName(String name) {
        return users.stream().
                filter(user -> user.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public static List<User> findUsersById(int fromId, int toId) {
        return users.stream()
                .filter(user -> user.getId() >= fromId && user.getId() <= toId)
                .collect(Collectors.toList());
    }
}
