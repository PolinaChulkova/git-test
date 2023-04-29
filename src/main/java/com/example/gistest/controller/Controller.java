package com.example.gistest.controller;

import com.example.gistest.dto.RegistrationRequest;
import com.example.gistest.entity.Entity;
import com.example.gistest.entity.User;
import com.example.gistest.service.EntityService;
import com.example.gistest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Controller {

    private final UserService userService;
    private final EntityService entityService;

    @GetMapping("/all")
    public Flux<Entity> getAllUserEntities(Principal principal) {
        return entityService.findAllByUserId(userService.getUserIdByUsername(principal.getName()));
    }

    @PostMapping("/add")
    public Entity addEntity(@RequestParam("entityName") String entityName, Principal principal) {
        return entityService.addEntity(userService.getUserIdByUsername(principal.getName()), entityName);
    }

    @PostMapping("/register")
    public User register(@RequestBody RegistrationRequest registrationRequest) {
        return userService.registerUser(registrationRequest);
    }
}
