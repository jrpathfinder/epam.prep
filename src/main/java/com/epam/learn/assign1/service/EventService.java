package com.epam.learn.assign1.service;

import com.epam.learn.assign1.dao.EventDAO;
import lombok.RequiredArgsConstructor;
import com.epam.learn.assign1.model.Event;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventService {

    private final EventDAO dao;

    public Event get(long eventId) {
        return dao.get(eventId);
    }
}
