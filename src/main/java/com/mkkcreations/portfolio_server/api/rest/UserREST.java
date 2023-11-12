package com.mkkcreations.portfolio_server.api.rest;

import com.mkkcreations.portfolio_server.api.model.User;
import com.mkkcreations.portfolio_server.api.service.LogService;
import com.mkkcreations.portfolio_server.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.net.InetAddress;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserREST {
    @Autowired
    UserService userService;

    @Autowired
    LogService logService;

    @GetMapping("/data")
    public ResponseEntity<?> data() {
        logService.createLog(
                "User",
                "User data requested",
                Map.of());
        return ResponseEntity.ok(userService.findByUsername("khaffou"));
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    @PreAuthorize("#user.id == #id")
    public ResponseEntity<?> me(@AuthenticationPrincipal User user, @PathVariable String id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("#user.id == #id")
    public ResponseEntity<?> update(@AuthenticationPrincipal User user, @PathVariable String id, @RequestBody User newUser) {
        return ResponseEntity.ok(userService.update(user, newUser));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user) {
        return ResponseEntity.ok(userService.create(user));
    }
}