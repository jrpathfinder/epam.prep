package com.epam.learn.assign1.service;

import com.epam.learn.assign1.dao.UserDao;
import com.epam.learn.assign1.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UserService {
    private final UserDao dao;

    public User get(long eventId) {
        return dao.get(eventId);
    }
    public User get(String email) {
        return dao.get(email);
    }

    public List<User> getByNames(String name) {
        return dao.getByName(name);
    }

    public User put(User user) {
        return dao.put(user);
    }

    public boolean remove(long eventId) {
        return dao.remove(eventId);
    }
}
