package com.epam.learn.assign1.storage;

import com.epam.learn.assign1.model.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class InMemoryStorage {

    public Map<String, List> data = new HashMap<>();

    public List<Event> events = new ArrayList<>();

    @Value("data.json")
    private Resource storageDataFile;

    @PostConstruct
    void setUp() throws IOException {
        File file = storageDataFile.getFile();
        ObjectMapper mapper = new ObjectMapper();
        data = mapper.readValue(file, Map.class);
        events = toEvents(data.get("events"));

        System.out.println(events);
    }

    private List<Event> toEvents(List<LinkedHashMap> events) {
        return events.stream().map(el -> {
            Event e = new Event();
            e.setId(Long.valueOf((String) el.get("id")));
            e.setTitle((String) el.get("title"));
            e.setDate(new Date());
            return e;
        }).collect(Collectors.toList());
    }
}
