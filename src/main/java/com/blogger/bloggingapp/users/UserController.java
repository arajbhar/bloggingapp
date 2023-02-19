package com.blogger.bloggingapp.users;

import com.blogger.bloggingapp.users.dto.CreateUserDTO;
import com.blogger.bloggingapp.users.dto.UserResponseDTO;
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
                .created(URI.create("/Users/"+savedUser.getId()))
                .body(savedUser);

    }

    @GetMapping("")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }


}
