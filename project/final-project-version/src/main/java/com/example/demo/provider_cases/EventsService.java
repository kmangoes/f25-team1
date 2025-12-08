package com.example.demo.provider_cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class EventsService {
    
@Autowired
private EventsRepository eventsRepository;

//endpoint mapping methods
public Object getAllEvents() {
    return eventsRepository.findAll();
}
public Events getEventById(@PathVariable Long id) {
    return eventsRepository.findById(id).orElse(null);
}
public Object getEventByName(String eventName) {
    return eventsRepository.getEventByName(eventName);
}
public Events addEvent(Events event) {
    return eventsRepository.save(event);
}
public void deleteEvent(Long eventId) {
    eventsRepository.deleteById(eventId);
}

}
