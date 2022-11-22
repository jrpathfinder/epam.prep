package com.epam.learn.assign1;

import com.epam.learn.assign1.facade.BookingFacade;
import com.epam.learn.assign1.model.Event;
import com.epam.learn.assign1.model.Ticket;
import com.epam.learn.assign1.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
@Slf4j
public class App implements CommandLineRunner {

    @Autowired
    BookingFacade facade;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Event event = facade.getEventById(1);
        log.info("get event by id {} {}", 1, event);

        List<Event> events = facade.getEventsByTitle("Event1", 1, 1);
        log.info("get events by title {} {}", "Event1", events);

        String dateInString = "22-10-2022";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy", Locale.ENGLISH);
        Date date = formatter.parse(dateInString);
        List<Event> eventsForDay = facade.getEventsForDay(date, 1, 1);
        log.info("get events for day {} {}", dateInString, eventsForDay);

        Event newEvent = new Event();
        newEvent.setId(3L);
        newEvent.setDate(new Date());
        newEvent.setTitle("new title");
        facade.createEvent(newEvent);
        log.info("created new event {}", newEvent);

        event.setTitle("updated");
        facade.updateEvent(event);
        log.info("update event {}", event);

        facade.deleteEvent(event.getId());
        log.info("delete event {}", event);

        User user = facade.getUserById(1);
        log.info("get user by id {} {}", 1, user);

        Ticket ticket = facade.bookTicket(user.getId(), 1, 1, Ticket.Category.BAR);
        log.info("book ticket {} for user {} event {}",ticket, user, event );

        List<Ticket> ticketsByEvent = facade.getBookedTickets(event, 1, 1);
        log.info("booked tickets {} for event {}", ticketsByEvent, event);

        List<Ticket> ticketsByUser = facade.getBookedTickets(user, 1, 1);
        log.info("booked tickets {} for user {}", ticketsByUser, user);

        boolean canceled = facade.cancelTicket(ticket.getId());
        log.info("canceled booked ticket {} - {} ", ticket.getId(), canceled);
    }
}
