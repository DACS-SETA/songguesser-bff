package com.songguesser.bff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.songguesser.bff.api.client.ApiBackendClient;
import com.songguesser.bff.dto.UpdateProfileDto;
import com.songguesser.bff.dto.UserDto;
import com.songguesser.bff.dto.UserProfileDto;
import com.songguesser.bff.dto.UserRankingDto;
import com.songguesser.bff.util.JwtUtils;

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
    
    @GetMapping("/ranking")
    public ResponseEntity<List<UserRankingDto>> getRanking() {
        List<UserRankingDto> ranking = apiBackendClient.getRanking();
        return ResponseEntity.ok(ranking);
    }

    @GetMapping("/profile")
    public ResponseEntity<UserProfileDto> getUserProfile(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        String keycloakId = JwtUtils.extractSub(token);
        UserProfileDto profile = apiBackendClient.getUserProfile(keycloakId);
        return ResponseEntity.ok(profile);
    }

    @PutMapping("/profile")
    public ResponseEntity<Void> updateUserProfile(@RequestHeader("Authorization") String authHeader, @RequestBody UpdateProfileDto dto) {
        String token = authHeader.replace("Bearer ", "");
        String keycloakId = JwtUtils.extractSub(token);
        apiBackendClient.updateProfile(keycloakId, dto);
        return ResponseEntity.ok().build();
    }
}
