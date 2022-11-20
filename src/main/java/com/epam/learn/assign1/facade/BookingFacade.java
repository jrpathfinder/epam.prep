package com.epam.learn.assign1.facade;

import lombok.RequiredArgsConstructor;
import com.epam.learn.assign1.model.Event;
import com.epam.learn.assign1.model.Ticket;
import com.epam.learn.assign1.model.User;
import org.springframework.stereotype.Component;
import com.epam.learn.assign1.service.EventService;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookingFacade{

    private final EventService eventService;

    public Event getEventById(long eventId) {
        return eventService.get(eventId);
    }


    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return null;
    }


    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return Collections.emptyList();
    }


    public Event createEvent(Event event) {
        return null;
    }


    public Event updateEvent(Event event) {
        return null;
    }


    public boolean deleteEvent(long eventId) {
        return false;
    }


    public User getUserById(long userId) {
        return null;
    }


    public User getUserByEmail(String email) {
        return null;
    }


    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return Collections.emptyList();
    }


    public User createUser(User user) {
        return null;
    }


    public User updateUser(User user) {
        return null;
    }


    public boolean deleteUser(long userId) {
        return false;
    }


    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return null;
    }


    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return Collections.emptyList();
    }


    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return Collections.emptyList();
    }


    public boolean cancelTicket(long ticketId) {
        return false;
    }
}
