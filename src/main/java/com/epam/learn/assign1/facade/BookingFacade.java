package com.epam.learn.assign1.facade;

import com.epam.learn.assign1.service.TicketService;
import com.epam.learn.assign1.service.UserService;
import lombok.RequiredArgsConstructor;
import com.epam.learn.assign1.model.Event;
import com.epam.learn.assign1.model.Ticket;
import com.epam.learn.assign1.model.User;
import org.springframework.stereotype.Component;
import com.epam.learn.assign1.service.EventService;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookingFacade{

    private final EventService eventService;
    private final UserService userService;
    private final TicketService ticketService;


    public Event getEventById(long eventId) {
        return eventService.get(eventId);
    }


    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventService.get(title);
    }


    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventService.get(day);
    }


    public Event createEvent(Event event) {
        return eventService.put(event);
    }


    public Event updateEvent(Event event) {
        return eventService.put(event);
    }


    public boolean deleteEvent(long eventId) {
        return eventService.remove(eventId);
    }


    public User getUserById(long userId) {
        return userService.get(userId);
    }


    public User getUserByEmail(String email) {
        return userService.get(email);
    }


    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userService.getByNames(name);
    }


    public User createUser(User user) {
        return userService.put(user);
    }


    public User updateUser(User user) {
        return userService.put(user);
    }


    public boolean deleteUser(long userId) {
        return userService.remove(userId);
    }


    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return ticketService.book(userId, eventId, place, category);
    }


    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketService.getByUser(user);
    }


    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketService.getByEvent(event);
    }


    public boolean cancelTicket(long ticketId) {
        return ticketService.cancel(ticketId);
    }
}
