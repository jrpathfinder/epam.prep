package com.epam.learn.assign1.storage;

import com.epam.learn.assign1.model.Event;
import com.epam.learn.assign1.model.Ticket;
import com.epam.learn.assign1.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Component
@Slf4j
public class InMemoryStorage {

    public Map<String, List> data = new HashMap<>();
    public List<Event> events = new ArrayList<>();
    public List<User> users = new ArrayList<>();
    public List<Ticket> tickets = new ArrayList<>();

    @Value("data.json")
    private Resource storageDataFile;

    @PostConstruct
    void setUp() throws IOException {
        File file = storageDataFile.getFile();
        ObjectMapper mapper = new ObjectMapper();
        data = mapper.readValue(file, Map.class);
        events = toEvents(data.get("events"));
        users = toUsers(data.get("users"));
        tickets = toTickets(data.get("tickets"));
        log.info("Events: {}", events);
        log.info("Users: {}", users);
        log.info("Tickets: {}", tickets);
    }

    private List<Ticket> toTickets(List<LinkedHashMap> tickets) {
        return tickets.stream().map(el -> {
            Ticket t = new Ticket();
            t.setId(Long.valueOf((Integer) el.get("id")));
            t.setCategory(Ticket.Category.BAR);
            t.setEvent(toEvent((LinkedHashMap) el.get("event")));
            t.setUser(toUser((LinkedHashMap) el.get("user")));
            t.setPlace((Integer) el.get("place"));
            return t;
        }).collect(Collectors.toList());
    }

    private List<User> toUsers(List<LinkedHashMap> users) {
        return users.stream().map(el -> {
            User e = new User();
            e.setId(Long.valueOf((Integer) el.get("id")));
            e.setName((String) el.get("name"));
            e.setEmail((String) el.get("email"));
            return e;
        }).collect(Collectors.toList());
    }

    private User toUser(LinkedHashMap el) {
        User user = new User();
        user.setId(Long.valueOf((Integer) el.get("id")));
        user.setName((String) el.get("name"));
        user.setEmail((String) el.get("email"));
        return user;
    }

    private Event toEvent(LinkedHashMap el) {
        Event event = new Event();
        event.setId(Long.valueOf((Integer) el.get("id")));
        event.setTitle((String) el.get("title"));
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a", Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        try {
            event.setDate(formatter.parse((String) el.get("date")));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return event;
    }

    private List<Event> toEvents(List<LinkedHashMap> events) {
        return events.stream().map(el -> {
            Event e = new Event();
            e.setId(Long.valueOf((Integer) el.get("id")));
            e.setTitle((String) el.get("title"));
            SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a", Locale.ENGLISH);
            formatter.setTimeZone(TimeZone.getTimeZone("America/New_York"));
            try {
                e.setDate(formatter.parse((String) el.get("date")));
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            return e;
        }).collect(Collectors.toList());
    }
}
