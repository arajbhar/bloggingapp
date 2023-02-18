package com.blogger.bloggingapp.users;

import com.blogger.bloggingapp.commons.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "users")
public class UserEntity extends BaseEntity {

    @Column(unique = true,nullable = false,length = 50)
    String username;
    String password; //TO DO hash password
    String bio;
    String image;
}
