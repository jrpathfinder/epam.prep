package com.epam.learn.assign1;

import com.epam.learn.assign1.facade.BookingFacade;
import com.epam.learn.assign1.model.Event;
import com.epam.learn.assign1.model.Ticket;
import com.epam.learn.assign1.model.TicketCategory;
import com.epam.learn.assign1.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
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
    }
}
