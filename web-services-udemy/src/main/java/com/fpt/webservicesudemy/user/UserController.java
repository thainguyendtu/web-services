package com.fpt.webservicesudemy.user;

import com.fpt.webservicesudemy.common.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public APIResponse<?> retrieveAllUsers() {
        return APIResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Get users data successfully")
                .data(userService.retrieveAllUsers())
                .build();
    }

    @GetMapping("/{id}")
    public APIResponse<?> retrieveUser(@PathVariable Integer id) {
        return APIResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Get users data with id: " + id + " successfully")
                .data(userService.retrieveUser(id))
                .build();
    }

    @PostMapping
    public APIResponse<?> addUser(@RequestBody User user) {
        return APIResponse.builder()
                .statusCode(HttpStatus.CREATED.value())
                .message("Get users data successfully")
                .data(userService.addUser(user))
                .build();
    }

    @DeleteMapping("/{id}")
    public APIResponse<?> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return APIResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Get users data successfully")
                .build();
    }
}
