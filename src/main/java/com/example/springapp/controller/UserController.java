package com.example.springapp.controller;

import com.example.springapp.domain.User;
import com.example.springapp.dto.UserDto;
import com.example.springapp.mapper.UserMapper;
import com.example.springapp.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User Controller", description = "The User API")
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        User user = UserMapper.INSTANCE.userDtoToUser(userDto);
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> findAll(Model model) {
        List<UserDto> userDtos = UserMapper.INSTANCE.userToDtos(userService.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(userDtos);
    }

    @DeleteMapping("/user-delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User with id : " + id + " deleted");
    }


    @PutMapping("/user-update")
    public ResponseEntity<UserDto> updateUser(User user) {
        UserDto userDto = UserMapper.INSTANCE.userToDto(userService.saveUser(user));
        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }

}
