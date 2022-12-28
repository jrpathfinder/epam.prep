package com.epam.learn.assign1.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by maksym_govorischev.
 */
@Data
@Builder
public class Ticket {
    /**
     * com.epam.learn.assign1.model.Ticket Id. UNIQUE.
     * @return com.epam.learn.assign1.model.Ticket Id.
     */
    Long id;
    Event event;
    User user;
    TicketCategory category;
    Integer place;
    Boolean booked;

}
