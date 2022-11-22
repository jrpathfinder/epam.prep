package com.epam.learn.assign1.service;

import com.epam.learn.assign1.dao.TicketDao;
import com.epam.learn.assign1.model.Event;
import com.epam.learn.assign1.model.Ticket;
import com.epam.learn.assign1.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TicketService {
    private final TicketDao dao;
    public Ticket book(long userId, long eventId, int place, Ticket.Category category) {
        Ticket ticket =  dao.find(userId, eventId, place, category);
        ticket.setBooked(true);
        return dao.put(ticket);
    }

    public List<Ticket> getByUser(User user) {
        return dao.get(user);
    }

    public List<Ticket> getByEvent(Event event) {
        return dao.get(event);
    }

    public boolean cancel(long id) {
        Ticket t = dao.get(id);
        t.setBooked(false);
        dao.put(t);
        return true;
    }
}
