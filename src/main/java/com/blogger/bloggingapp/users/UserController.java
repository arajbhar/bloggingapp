package com.blogger.bloggingapp.users;

import com.blogger.bloggingapp.users.dto.CreateUserDTO;
import com.blogger.bloggingapp.users.dto.LoginUserDTO;
import com.blogger.bloggingapp.users.dto.UserResponseDTO;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



    @PostMapping("")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody CreateUserDTO createUserDTO){

        var savedUser=userService.createUser(createUserDTO);
        return ResponseEntity
                .created(URI.create("/users/"+savedUser.getId()))
                .body(savedUser);

    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> loginUser(@RequestBody LoginUserDTO loginUserDTO){

        var loginUser=userService.loginUser(loginUserDTO);
        return  ResponseEntity.ok(loginUser);
    }

    @GetMapping("")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @ExceptionHandler(UserService.UserNotFoundException.class)
    public ResponseEntity<String> handelUserNotFoundException(UserService.UserNotFoundException e){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public  ResponseEntity<String> handleIncorrectPassword(IllegalArgumentException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }



}
