package com.epam.learn.assign1.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Created by maksym_govorischev.
 */
@Data
@Accessors(chain = true)
public class Event {
    /**
     * com.epam.learn.assign1.model.Event id. UNIQUE.
     * @return com.epam.learn.assign1.model.Event Id
     */
    private Long id;
    private String title;
    private Date date;
}
