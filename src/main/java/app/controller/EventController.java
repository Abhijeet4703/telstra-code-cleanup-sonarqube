package app.controller;

import app.Model.Event;
import app.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PostMapping
    public Event create(@RequestBody Event event) {
        return service.save(event);
    }

    @GetMapping
    public List<Event> getAll() {
        return service.getAll();
    }
}
