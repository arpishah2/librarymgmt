package com.mgmt.librarymgmt.Controller;

import com.mgmt.librarymgmt.DataAccessLayer.User;
import com.mgmt.librarymgmt.Exception.UserNotFoundException;
import com.mgmt.librarymgmt.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    List<User> getAllUsers() {
        try {
            return userService.getAllUsers();
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Users Found", e);
        }
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable int id){
        try {
            return userService.getUserById(id);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No User Found", e);
        }
    }

}
