package com.blogger.bloggingapp;

import com.blogger.bloggingapp.users.UserRepository;
import com.blogger.bloggingapp.users.UserService;
import com.blogger.bloggingapp.users.dto.CreateUserDTO;
import com.blogger.bloggingapp.users.dto.UserResponseDTO;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    private UserService getUserService(){
        ModelMapper modelMapper=new ModelMapper();
        var userService= new UserService(userRepository,modelMapper);
        return userService;
    }

    @Test
    public void createUserTest(){
        CreateUserDTO createUserDTO = new CreateUserDTO();
        createUserDTO.setUsername("arajbhar");
        createUserDTO.setEmail("a@gmail.com");
        createUserDTO.setPassword("xxxxx");

        var createdUser=getUserService().createUser(createUserDTO);
        assertNotNull(createdUser);
    }

    @Test
    public void getAllUsersTest(){
        CreateUserDTO createUserDTO1 = new CreateUserDTO();
        createUserDTO1.setUsername("arajbhar");
        createUserDTO1.setEmail("a@gmail.com");
        createUserDTO1.setPassword("xxxxx");

        var createdUser1=getUserService().createUser(createUserDTO1);

        CreateUserDTO createUserDTO2 = new CreateUserDTO();
        createUserDTO2.setUsername("rajbhar");
        createUserDTO2.setEmail("r@gmail.com");
        createUserDTO2.setPassword("xxxxxx");

        var createdUser2=getUserService().createUser(createUserDTO2);

        List<UserResponseDTO> listOfUsers=new ArrayList<>();

        listOfUsers=getUserService().getAllUsers();

        assertEquals(2,listOfUsers.size());

    }
}
