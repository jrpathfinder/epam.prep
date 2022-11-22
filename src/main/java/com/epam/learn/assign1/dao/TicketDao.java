package com.epam.learn.assign1.dao;

import com.epam.learn.assign1.model.Event;
import com.epam.learn.assign1.model.Ticket;
import com.epam.learn.assign1.model.User;
import com.epam.learn.assign1.storage.InMemoryStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TicketDao {
    private final InMemoryStorage storage;
    public Ticket find(long userId, long eventId, int place, Ticket.Category category) {
        return storage.tickets.stream()
                .filter(i -> i.getEvent().getId() == eventId && i.getUser().getId() == userId &&
                        i.getPlace() == place && i.getCategory() == category)
                .findAny().get();
    }

    public Ticket put(Ticket ticket) {
        if (storage.tickets.contains(ticket)) {
            storage.tickets.set(storage.tickets.indexOf(ticket), ticket);
        } else {
            storage.tickets.add(ticket);
        }
        return ticket;
    }

    public List<Ticket> get(User user) {
        return storage.tickets.stream()
                .filter(t-> t.getUser().getId().equals(user.getId()) && t.isBooked())
                .collect(Collectors.toList());
    }

    public List<Ticket> get(Event event) {
        return storage.tickets.stream()
                .filter(t-> t.getEvent().getId().equals(event.getId()) && t.isBooked())
                .collect(Collectors.toList());
    }

    public Ticket get(long id) {
        return storage.tickets.stream()
                .filter(t -> t.getId().equals(id) && t.isBooked())
                .findAny().get();
    }
}
