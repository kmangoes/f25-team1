package com.example.CafeQuestApiApplication.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CafeQuestApiApplication.entity.CoffeeShop;
import com.example.CafeQuestApiApplication.entity.Event;
import com.example.CafeQuestApiApplication.entity.EventAttendee;
import com.example.CafeQuestApiApplication.entity.User;
import com.example.CafeQuestApiApplication.repository.CoffeeShopRepository;
import com.example.CafeQuestApiApplication.repository.EventAttendeeRepository;
import com.example.CafeQuestApiApplication.repository.EventRepository;
import com.example.CafeQuestApiApplication.repository.UserRepository;

@Service
public class EventService {
    
    @Autowired
    private EventRepository eventRepository;
    
    @Autowired
    private EventAttendeeRepository attendeeRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CoffeeShopRepository coffeeShopRepository;
    
    // Create new event
    public Event createEvent(Long userId, Long shopId, Event event) {
        User organizer = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        
        CoffeeShop shop = coffeeShopRepository.findById(shopId)
            .orElseThrow(() -> new IllegalArgumentException("Coffee shop not found"));
        
        // Validate date is in future
        if (event.getEventDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Event date must be in the future");
        }
        
        event.setOrganizer(organizer);
        event.setCoffeeShop(shop);
        event.setCurrentAttendees(1);
        
        Event savedEvent = eventRepository.save(event);
        
        // Auto-register organizer as attendee
        EventAttendee attendance = new EventAttendee(savedEvent, organizer, EventAttendee.RsvpStatus.GOING);
        attendeeRepository.save(attendance);
        
        return savedEvent;
    }
    
    // Get all events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
    
    // Get event by ID
    public Event getEventById(Long id) {
        return eventRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Event not found"));
    }
    
    // Get events by organizer
    public List<Event> getEventsByOrganizer(Long userId) {
        return eventRepository.findByOrganizer_UserId(userId);
    }
    
    // Get events by shop
    public List<Event> getEventsByShop(Long shopId) {
        return eventRepository.findByCoffeeShop_ShopId(shopId);
    }
    
    // Get user's events (organized or attending)
    public List<Event> getUserEvents(Long userId) {
        // Get events organized by user
        List<Event> organizedEvents = eventRepository.findByOrganizer_UserId(userId);
        
        // Get events user is attending
        List<EventAttendee> attendances = attendeeRepository.findByUser_UserId(userId);
        List<Event> attendingEvents = attendances.stream()
            .filter(a -> a.getRsvpStatus() == EventAttendee.RsvpStatus.GOING || 
                        a.getRsvpStatus() == EventAttendee.RsvpStatus.MAYBE)
            .map(EventAttendee::getEvent)
            .collect(Collectors.toList());
        
        // Combine and remove duplicates
        organizedEvents.addAll(attendingEvents);
        return organizedEvents.stream().distinct().collect(Collectors.toList());
    }
    
    // Update event
    public Event updateEvent(Long id, Event eventDetails) {
        Event event = getEventById(id);
        
        if (eventDetails.getName() != null) {
            event.setName(eventDetails.getName());
        }
        if (eventDetails.getDescription() != null) {
            event.setDescription(eventDetails.getDescription());
        }
        if (eventDetails.getEventDate() != null) {
            if (eventDetails.getEventDate().isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("Event date must be in the future");
            }
            event.setEventDate(eventDetails.getEventDate());
        }
        if (eventDetails.getEventTime() != null) {
            event.setEventTime(eventDetails.getEventTime());
        }
        if (eventDetails.getMaxAttendees() != null) {
            event.setMaxAttendees(eventDetails.getMaxAttendees());
        }
        if (eventDetails.getIsPublic() != null) {
            event.setIsPublic(eventDetails.getIsPublic());
        }
        
        return eventRepository.save(event);
    }
    
    // Delete event
    public void deleteEvent(Long id) {
        Event event = getEventById(id);
        eventRepository.delete(event);
    }
    
    // Join event (RSVP)
    public EventAttendee joinEvent(Long eventId, Long userId, EventAttendee.RsvpStatus status) {
        Event event = getEventById(eventId);
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        
        // Check if already registered
        if (attendeeRepository.findByEvent_EventIdAndUser_UserId(eventId, userId).isPresent()) {
            throw new IllegalArgumentException("User already registered for this event");
        }
        
        // Check capacity
        if (event.getMaxAttendees() != null && 
            event.getCurrentAttendees() >= event.getMaxAttendees()) {
            throw new IllegalArgumentException("Event is at full capacity");
        }
        
        EventAttendee attendance = new EventAttendee(event, user, status);
        EventAttendee saved = attendeeRepository.save(attendance);
        
        // Update attendee count if GOING
        if (status == EventAttendee.RsvpStatus.GOING) {
            event.setCurrentAttendees(event.getCurrentAttendees() + 1);
            eventRepository.save(event);
        }
        
        return saved;
    }
    
    // Update RSVP status
    public EventAttendee updateRsvp(Long eventId, Long userId, EventAttendee.RsvpStatus newStatus) {
        EventAttendee attendance = attendeeRepository.findByEvent_EventIdAndUser_UserId(eventId, userId)
            .orElseThrow(() -> new IllegalArgumentException("Attendance record not found"));
        
        EventAttendee.RsvpStatus oldStatus = attendance.getRsvpStatus();
        attendance.setRsvpStatus(newStatus);
        EventAttendee updated = attendeeRepository.save(attendance);
        
        // Update attendee count
        Event event = attendance.getEvent();
        if (oldStatus != EventAttendee.RsvpStatus.GOING && newStatus == EventAttendee.RsvpStatus.GOING) {
            event.setCurrentAttendees(event.getCurrentAttendees() + 1);
        } else if (oldStatus == EventAttendee.RsvpStatus.GOING && newStatus != EventAttendee.RsvpStatus.GOING) {
            event.setCurrentAttendees(event.getCurrentAttendees() - 1);
        }
        eventRepository.save(event);
        
        return updated;
    }
    
    // Leave event
    public void leaveEvent(Long eventId, Long userId) {
        EventAttendee attendance = attendeeRepository.findByEvent_EventIdAndUser_UserId(eventId, userId)
            .orElseThrow(() -> new IllegalArgumentException("Attendance record not found"));
        
        Event event = attendance.getEvent();
        
        // Decrease attendee count if was GOING
        if (attendance.getRsvpStatus() == EventAttendee.RsvpStatus.GOING) {
            event.setCurrentAttendees(event.getCurrentAttendees() - 1);
            eventRepository.save(event);
        }
        
        attendeeRepository.delete(attendance);
    }
}