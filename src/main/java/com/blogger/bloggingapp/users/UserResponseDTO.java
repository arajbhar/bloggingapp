package com.blogger.bloggingapp.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDTO {

    String Id;
    String username;
    String email;
    String bio;
    String image;
}
