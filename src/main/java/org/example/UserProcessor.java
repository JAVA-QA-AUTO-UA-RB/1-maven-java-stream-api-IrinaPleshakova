package org.example;

import org.example.dto.User;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserProcessor {

    public static List<User> filterAndSortUsers(List<User> users) {
        // Напишіть реалізацію метода, який повертає новий список.
        // список, що повертається має містити тільки юзерів, у яких:
        // а) вік більше 25 років
        // б) Імейл закінчується на "ilovedogs.com" АБО "ilovecats.com"
        // список, що повертається повинен бути відсортованим по полю "name" в алфавітному порядку Ascending (тобто від A -> Z)

        //!!! У тілі метода ЗАБОРОНЕНО використовувати класичні цикли for, while, do-while для перебору по колекціям
        return users.stream()
                .filter(user -> user.getAge() > 25)
                .filter(user -> user.getEmail().endsWith("ilovedogs.com") || user.getEmail().endsWith("ilovecats.com"))
                .sorted(Comparator.comparing(User::getName))
                        .collect(Collectors.toList());
    }
}
