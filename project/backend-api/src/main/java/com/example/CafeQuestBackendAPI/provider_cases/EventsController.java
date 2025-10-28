package com.example.CafeQuestBackendAPI.provider_cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventsController {
    
@Autowired
private EventsService eventsService;

@GetMapping("/events")
public Object getAllEvents() {
    return eventsService.getAllEvents();
}
@GetMapping("/events/{eventId}")
public Object getEventById(@PathVariable Long eventId) {
    return eventsService.getEventById(eventId);
}
@GetMapping("/events/eventName")
public Object getEventByName(@RequestParam String eventName) {
    if (eventName != null) {
        return eventsService.getEventByName(eventName);
    } else {
        return eventsService.getAllEvents();
    }
}
@PostMapping("/events")
public Events addEvent (@RequestBody Events event) {
    return eventsService.addEvent(event);
}
@DeleteMapping("/events/{eventId}")
public void deleteEvent(@PathVariable Long eventId) {
    eventsService.deleteEvent(eventId);
}

}
