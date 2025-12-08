package com.example.demo.provider_cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class EventsController {
    
@Autowired
private EventsService eventsService;
@Autowired
private CafeService cafesService;

@GetMapping("/events")
public Object getAllEvents(Model model) {
    //return eventsService.getAllEvents();
    model.addAttribute("eventsList", eventsService.getAllEvents());
    return "event_dashboard"; //returns event_dashboard.ftlh
}
@GetMapping("/events/eventName")
public Object getEventByName(@RequestParam String eventName) {
    if (eventName != null) {
        return eventsService.getEventByName(eventName);
    } else {
        return eventsService.getAllEvents();
    }
}

@GetMapping("/events/createForm") 
public Object showAddEventForm(Model model) {
    System.out.println("Reached showAddEventForm method in EventsController");
    model.addAttribute("title", "Sanity check"); 
    model.addAttribute("event", new Events()); //freemarker objects calling event.(X)
    model.addAttribute("cafes", cafesService.getAllCafes()); //get list of cafe names
    return "create_event_form"; //shows create_event_form.ftlh 
}
@PostMapping("/events")
public Object addEvent (Events event) {
    Events newEvent = eventsService.addEvent(event);
    System.out.println("Event added: " + newEvent.getEventName()); //sanity check 
    return "redirect:/events";
}

@GetMapping("/events/delete/{eventId}")
public Object deleteEvent(@PathVariable Long eventId) {
    eventsService.deleteEvent(eventId);
    return "redirect:/events";
}

}
