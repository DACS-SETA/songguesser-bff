package com.songguesser.bff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.songguesser.bff.api.client.ApiBackendClient;
import com.songguesser.bff.dto.UserDto;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private ApiBackendClient apiBackendClient;

    @PostMapping("/sync")
    public ResponseEntity<Void> syncUser(@RequestBody UserDto userDto) {
        apiBackendClient.syncUser(userDto);
        return ResponseEntity.ok().build();
    }
}
