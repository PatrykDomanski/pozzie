package Pozzie.controllers;

import Pozzie.Greetings;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@Component
public class EgController<Greetengs> {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/gree")
    public Greetengs greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return (Greetengs) new Greetings(counter.incrementAndGet(),
                String.format(template, name));
    }
}
