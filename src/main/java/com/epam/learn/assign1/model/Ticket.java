package com.epam.learn.assign1.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by maksym_govorischev.
 */
@Data
@Accessors(chain = true)
public class Ticket {
    public enum Category {STANDARD, PREMIUM, BAR}

    /**
     * com.epam.learn.assign1.model.Ticket Id. UNIQUE.
     * @return com.epam.learn.assign1.model.Ticket Id.
     */
    private long id;
    private Event event;
    private User user;
    private Category category;
    private int place;

}
