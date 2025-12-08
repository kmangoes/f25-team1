package com.example.demo.backend;

import java.security.Principal;
import java.util.List;

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
private ProviderService providerService;
@Autowired
private EventsService eventsService;
@Autowired
private CafeService cafesService;
@Autowired
private UserService userService;
@Autowired
private EventsRepository eventsRepository;

@GetMapping("/provider/events")
public Object getAllEvents(Model model) {
    //return eventsService.getAllEvents();
    model.addAttribute("eventsList", eventsService.getAllEvents());
    return "prov_event_dashboard"; //returns event_dashboard.ftlh
}

//dashboard for users to see events they HAVEN'T joined OR didn't create
@GetMapping("/users/events")
public String showUserEventsDashboard(Model model, Principal principal) {
    User user = userService.getByUsername(principal.getName());
    List<Events> availableEvents =
        eventsRepository.findAllWhereUserNotAttending(user);
    model.addAttribute("events", availableEvents);
    return "user_event_dashboard"; // user_event_dashboard.ftlh
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
public String addEvent(Events event, Principal principal) {

    if (principal != null) {
        String email = principal.getName();
        User user = userService.getByUsername(email);
        if (user != null) {
            event.setCreator(user);
        }
    }
    eventsService.addEvent(event);
    return "redirect:/provider/events";
}

@GetMapping("/events/delete/{eventId}")
public String deleteEvent(@PathVariable Long eventId) {
    eventsService.deleteEvent(eventId);
    return "redirect:/provider/events";
}

//method for user to join an event
@GetMapping("/users/events/join/{eventId}")
public String joinEvent(@PathVariable Long eventId, Principal principal) {
    User user = userService.getByUsername(principal.getName());
    Events event = eventsService.getEventById(eventId);
    event.getAttendees().add(user);
    eventsService.addEvent(event);
    return "redirect:/users/events";
}
@GetMapping("/users/events/leave/{eventId}")
public String leaveEvent(@PathVariable Long eventId, Principal principal) {
    User user = userService.getByUsername(principal.getName());
    Events event = eventsService.getEventById(eventId);
    event.getAttendees().remove(user);
    eventsService.addEvent(event);
    return "redirect:/users/events";
}
@GetMapping("/users/profile")
public String showProfile(Model model, Principal principal) {
    User user = userService.getByUsername(principal.getName());
    model.addAttribute("createdEvents", user.getCreatedEvents());
    model.addAttribute("joinedEvents", user.getAttendingEvents());

    return "user_activity_dashboard"; // returns user_activity_dashboard.ftlh
}

}
