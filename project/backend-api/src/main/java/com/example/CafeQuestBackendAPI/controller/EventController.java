package com.example.CafeQuestApiApplication.controller;

import com.example.CafeQuestApiApplication.entity.Event;
import com.example.CafeQuestApiApplication.entity.EventAttendee;
import com.example.CafeQuestApiApplication.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "*")
public class EventController {
    
    @Autowired
    private EventService eventService;
    
    // Create new event
    @PostMapping("/user/{userId}/shop/{shopId}")
    public ResponseEntity<?> createEvent(
            @PathVariable Long userId,
            @PathVariable Long shopId,
            @RequestBody Event event) {
        try {
            Event created = eventService.createEvent(userId, shopId, event);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
    // Get all events
    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }
    
    // Get event by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getEventById(@PathVariable Long id) {
        try {
            Event event = eventService.getEventById(id);
            return ResponseEntity.ok(event);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    
    // Get events by organizer
    @GetMapping("/organizer/{userId}")
    public ResponseEntity<List<Event>> getEventsByOrganizer(@PathVariable Long userId) {
        List<Event> events = eventService.getEventsByOrganizer(userId);
        return ResponseEntity.ok(events);
    }
    
    // Get events by coffee shop
    @GetMapping("/shop/{shopId}")
    public ResponseEntity<List<Event>> getEventsByShop(@PathVariable Long shopId) {
        List<Event> events = eventService.getEventsByShop(shopId);
        return ResponseEntity.ok(events);
    }
    
    // Get user's events (organized + attending)
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Event>> getUserEvents(@PathVariable Long userId) {
        List<Event> events = eventService.getUserEvents(userId);
        return ResponseEntity.ok(events);
    }
    
    // Update event
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        try {
            Event updated = eventService.updateEvent(id, event);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
    // Delete event
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long id) {
        try {
            eventService.deleteEvent(id);
            return ResponseEntity.ok("Event deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    
    // Join event (RSVP)
    @PostMapping("/{eventId}/join")
    public ResponseEntity<?> joinEvent(
            @PathVariable Long eventId,
            @RequestBody Map<String, Object> payload) {
        try {
            Long userId = Long.valueOf(payload.get("userId").toString());
            String statusStr = payload.get("status").toString();
            EventAttendee.RsvpStatus status = EventAttendee.RsvpStatus.valueOf(statusStr);
            
            EventAttendee attendance = eventService.joinEvent(eventId, userId, status);
            return ResponseEntity.status(HttpStatus.CREATED).body(attendance);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
    // Update RSVP
    @PutMapping("/{eventId}/rsvp")
    public ResponseEntity<?> updateRsvp(
            @PathVariable Long eventId,
            @RequestBody Map<String, Object> payload) {
        try {
            Long userId = Long.valueOf(payload.get("userId").toString());
            String statusStr = payload.get("status").toString();
            EventAttendee.RsvpStatus status = EventAttendee.RsvpStatus.valueOf(statusStr);
            
            EventAttendee updated = eventService.updateRsvp(eventId, userId, status);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
    // Leave event
    @DeleteMapping("/{eventId}/leave/{userId}")
    public ResponseEntity<?> leaveEvent(@PathVariable Long eventId, @PathVariable Long userId) {
        try {
            eventService.leaveEvent(eventId, userId);
            return ResponseEntity.ok("Left event successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}