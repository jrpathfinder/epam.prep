package com.epam.learn.assign1.service;

import com.epam.learn.assign1.dao.EventDAO;
import lombok.RequiredArgsConstructor;
import com.epam.learn.assign1.model.Event;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EventService {

    private final EventDAO dao;

    public Event get(long eventId) {
        return dao.get(eventId);
    }
    public List<Event> get(String title) {
        return dao.get(title);
    }

    public List<Event> get(Date date) {
        return dao.get(date);
    }

    public Event put(Event event) {
        return dao.put(event);
    }

    public boolean remove(long eventId) {
      return dao.remove(eventId);
    }
}
