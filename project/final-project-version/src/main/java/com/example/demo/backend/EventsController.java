package com.example.demo.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EventsController {

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

@GetMapping("/users/events")
public String showUserEventsDashboard(Model model, HttpServletRequest request) {
    System.out.println("Controller called: /users/events");
    String email = (String) request.getSession().getAttribute("userEmail");
    System.out.println("email retrieved from session: " + email);
    if (email == null) {
        return "redirect:/users/login";
    }
    User user = userService.getByEmail(email);
    List<Events> availableEvents = eventsRepository.findAllWhereUserNotAttending(user, user.getUserId());
    model.addAttribute("events", availableEvents);
    System.out.println("Event count = " + availableEvents.size());
    return "user_event_dashboard";
}


@GetMapping("/events/eventName")
public Object getEventByName(@RequestParam String eventName) {
    if (eventName != null) {
        return eventsService.getEventByName(eventName);
    } else {
        return eventsService.getAllEvents();
    }
}

@GetMapping("/users/events/createForm") 
public Object showAddEventForm(Model model) {
    System.out.println("Reached showAddEventForm method in EventsController");
    model.addAttribute("title", "Sanity check"); 
    model.addAttribute("event", new Events()); //freemarker objects calling event.(X)
    model.addAttribute("cafes", cafesService.getAllCafes()); //get list of cafe names
    return "user_create_event_form"; //shows create_event_form.ftlh 
}
@GetMapping("/provider/events/createForm")
public Object showProvAddEventForm(Model model) {
    System.out.println("Reached showAddEventForm method in EventsController");
    model.addAttribute("title", "Sanity check"); 
    model.addAttribute("event", new Events()); //freemarker objects calling event.(X)
    model.addAttribute("cafes", cafesService.getAllCafes()); //get list of cafe names
    return "prov_create_event_form"; //shows create_event_form.ftlh 
}
@PostMapping("/events")
public String addEvent(Events event, HttpServletRequest request) {
    String email = (String) request.getSession().getAttribute("userEmail");
    if (email != null) { 
        User user = userService.getByEmail(email);
        System.out.println("Posting event by: " + email);
        event.setCreator(user);
        eventsService.addEvent(event);
        return "redirect:/users/events";
    }
    eventsService.addEvent(event);
    return "redirect:/provider/events";
}

@GetMapping("/events/delete/{eventId}")
public String deleteEvent(@PathVariable Long eventId, HttpServletRequest request) {
    eventsService.deleteEvent(eventId);
    String userEmail = (String) request.getSession().getAttribute("userEmail");
    if (userEmail != null) {
        return "redirect:/users/myActivity";  // user dashboard
    }
    return "redirect:/provider/events";
}

@GetMapping("/users/events/join/{eventId}")
public String joinEvent(@PathVariable Long eventId, HttpServletRequest request) {
    String email = (String) request.getSession().getAttribute("userEmail");
    if (email == null) return "redirect:/users/login";
    User user = userService.getByEmail(email);
    Events event = eventsService.getEventById(eventId);

    //check for duplicates
    if (!event.getAttendees().contains(user)) {
        event.getAttendees().add(user);
        eventsService.addEvent(event);
    }
    return "redirect:/users/myActivity"; //redirect to user profile page showing joined/created events
}

@GetMapping("/users/events/leave/{eventId}")
public String leaveEvent(@PathVariable Long eventId, HttpServletRequest request) {
    String email = (String) request.getSession().getAttribute("userEmail");
    if (email == null) return "redirect:/users/login";
    User user = userService.getByEmail(email);
    Events event = eventsService.getEventById(eventId);
    event.getAttendees().remove(user);
    eventsService.addEvent(event);
    return "redirect:/users/myActivity";
}

}
