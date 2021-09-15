package com.black.skeleton.api.h5.controller;

import com.black.skeleton.biz.dto.UserDTO;
import com.black.skeleton.biz.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/h5/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public Optional<UserDTO> get(@RequestParam Long id) {
        return userService.get(id);
    }
}
