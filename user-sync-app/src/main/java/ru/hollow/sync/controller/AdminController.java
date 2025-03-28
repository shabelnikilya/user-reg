package ru.hollow.sync.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/admin")
@RestController
public class AdminController {

    @GetMapping
    public ResponseEntity<String> check() {
        return ResponseEntity.ok().build();
    }
}
