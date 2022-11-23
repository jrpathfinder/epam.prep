package com.epam.learn.assign1.dao;

import com.epam.learn.assign1.model.User;
import com.epam.learn.assign1.storage.InMemoryStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final InMemoryStorage storage;
    public User get(long eventId) {
        return storage.users
                .stream()
                .filter(i -> i.getId() == eventId)
                .findAny().get();
    }
    public User get(String email) {
        return storage.users
                .stream()
                .filter(i -> i.getEmail().equals(email))
                .findAny().get();
    }

    public List<User> getByName(String name) {
        return storage.users
                .stream()
                .filter(i -> i.getName().equals(name))
                .collect(Collectors.toList());
    }

    public User put(User user) {
        if (storage.users.contains(user)) {
            storage.users.set(storage.users.indexOf(user), user);
        } else {
            storage.users.add(user);
        }
        return user;
    }

    public boolean remove(long eventId) {
        Predicate<User> p = e -> e.getId().equals(eventId);
        return storage.users.removeIf(p);
    }
}
