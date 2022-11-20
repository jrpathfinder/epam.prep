package com.epam.learn.assign1.dao;

import com.epam.learn.assign1.model.Event;
import com.epam.learn.assign1.storage.InMemoryStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventDAO {

    private final InMemoryStorage storage;
    public Event get(long eventId) {
       return storage.events
                .stream()
                .filter(i -> i.getId() == eventId)
                .findAny().get();
        }
}
