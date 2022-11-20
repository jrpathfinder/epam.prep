package com.epam.learn.assign1.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by maksym_govorischev on 14/03/14.
 */
@Data
@Accessors(chain = true)
public class User {

    /**
     * com.epam.learn.assign1.model.User Id. UNIQUE.
     * @return com.epam.learn.assign1.model.User Id.
     */
    private long id;
    private String name;
    /**
     * com.epam.learn.assign1.model.User email. UNIQUE.
     * @return com.epam.learn.assign1.model.User email.
     */
    private String email;
}
