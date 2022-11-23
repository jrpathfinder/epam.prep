package com.epam.learn.assign1.dao;

import com.epam.learn.assign1.model.Event;
import com.epam.learn.assign1.storage.InMemoryStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    public List<Event> get(String title) {
       return storage.events
                .stream()
                .filter(i -> i.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    public List<Event> get(Date dt) {
        return storage.events
                .stream()
                .filter(i -> {
                    i.getDate().getTime();
                    final Calendar cal = Calendar.getInstance();
                    cal.setTime(i.getDate());
                    final int day = cal.get(Calendar.DAY_OF_MONTH);
                    final int month = cal.get(Calendar.MONTH);
                    final int year = cal.get(Calendar.YEAR);
                    cal.setTime(dt);
                    final int sDay = cal.get(Calendar.DAY_OF_MONTH);
                    final int sMonth = cal.get(Calendar.MONTH);
                    final int sYear = cal.get(Calendar.YEAR);
                    return (day == sDay && month == sMonth && year == sYear);
                })
                .collect(Collectors.toList());
    }

    public Event put(Event event) {
        if (storage.events.contains(event)) {
            storage.events.set(storage.events.indexOf(event), event);
        } else {
            storage.events.add(event);
        }
        return event;
    }

    public boolean remove(long eventId) {
        Predicate<Event> p = e -> e.getId().equals(eventId);
        return storage.events.removeIf(p);
    }
}
