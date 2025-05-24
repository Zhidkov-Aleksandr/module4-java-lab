package org.example.userapi.controller;

import org.example.userapi.model.User;
import org.example.userapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    /** GET  /user-api/v1/users */
    @GetMapping
    public List<User> getAllUsers() {
        return service.findAll();
    }

    /** POST /user-api/v1/users
     *  В теле запроса ожидается JSON, например:
     *  {
     *    "firstName": "John",
     *    "lastName":  "Doe",
     *    "role":      "DEVELOPER"
     *  }
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        return service.save(user);
    }
}
