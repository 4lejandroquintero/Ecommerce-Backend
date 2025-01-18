package com.deval.ecommerce.Backend.infrastructure.rest.user;

import com.deval.ecommerce.Backend.application.user.UserService;
import com.deval.ecommerce.Backend.domain.model.user.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http:localhost:4200")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    //http://localhost:8085/api/v1/users/4
    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id){
        return userService.findById(id);
    }
}