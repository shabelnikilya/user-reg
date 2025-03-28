package ru.hollow.sync.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hollow.jooq.tables.pojos.AppUser;
import ru.hollow.sync.dto.RegistrationDto;
import ru.hollow.sync.service.UserServiceImpl;

import java.time.LocalDateTime;
import java.util.UUID;

@RequestMapping("/users")
@RestController
public class AuthController {
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final UserServiceImpl userService;

    @Autowired
    public AuthController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/reg")
    public ResponseEntity<String> registration(
            @RequestBody RegistrationDto req
    ) {
        var user = toPojo(req);

        try {
            var registeredUser = userService.save(user);
            return ResponseEntity.ok(registeredUser.getId().toString());
        } catch (Exception e) {
            LOG.error("Error during registration: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<String> check() {
        return ResponseEntity.ok().build();
    }

    /**
     * Просто быстрый маппинг, не принципиальный на данный момент
     */
    private AppUser toPojo(RegistrationDto req) {
        return new AppUser(
                UUID.randomUUID(),
                req.firstName(),
                req.secondName(),
                null,
                req.role(),
                req.username(),
                req.password(),
                req.age(),
                null,
                null,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
