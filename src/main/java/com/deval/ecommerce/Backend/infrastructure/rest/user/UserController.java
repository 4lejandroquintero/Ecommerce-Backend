package com.deval.ecommerce.Backend.infrastructure.rest.user;

import com.deval.ecommerce.Backend.application.user.UserService;
import com.deval.ecommerce.Backend.domain.model.user.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id){
        return userService.findById(id);
    }
}
