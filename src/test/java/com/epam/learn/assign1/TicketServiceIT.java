package com.epam.learn.assign1;

import com.epam.learn.assign1.facade.BookingFacade;
import com.epam.learn.assign1.model.Event;
import com.epam.learn.assign1.model.Ticket;
import com.epam.learn.assign1.model.TicketCategory;
import com.epam.learn.assign1.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class TicketServiceIT {

    @Autowired
    BookingFacade facade;

    @Test
    void shouldBookThenCancelTheTicket() {
        Event event = facade.getEventById(1);
        assertEquals(1, event.getId());

        List<Event> eventsByTitle = facade.getEventsByTitle("Event1", 5, 1);
        assertEquals(1, event.getId());

        String dateInString = "2022-10-02T20:15:30+01:00";
        List<Event> eventsForDay = facade.getEventsForDay(OffsetDateTime.parse(dateInString, DateTimeFormatter.ISO_DATE_TIME), 1, 1);
        assertEquals(2, eventsForDay.size());
        log.info("get events for day {} {}", dateInString, eventsForDay);
        Event newEvent = Event.builder()
                .id(3L)
                .date(OffsetDateTime.now())
                .title("new title").build();
        facade.createEvent(newEvent);
        log.info("created new event {}", newEvent);

        facade.updateEvent(event);
        log.info("update event {}", event);

        facade.deleteEvent(event.getId());
        log.info("delete event {}", event);

        User user = facade.getUserById(1);
        log.info("get user by id {} {}", 1, user);

        Ticket ticket = facade.bookTicket(user.getId(), 1, 1, TicketCategory.BAR);
        log.info("book ticket {} for user {} event {}",ticket, user, event );

        List<Ticket> ticketsByEvent = facade.getBookedTickets(event, 1, 1);
        log.info("booked tickets {} for event {}", ticketsByEvent, event);

        List<Ticket> ticketsByUser = facade.getBookedTickets(user, 1, 1);
        log.info("booked tickets {} for user {}", ticketsByUser, user);

        boolean canceled = facade.cancelTicket(ticket.getId());
        log.info("canceled booked ticket {} - {} ", ticket.getId(), canceled);

        assertEquals(true, canceled);
    }
}