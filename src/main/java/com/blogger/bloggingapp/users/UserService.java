package com.blogger.bloggingapp.users;

import com.blogger.bloggingapp.users.dto.CreateUserDTO;
import com.blogger.bloggingapp.users.dto.LoginUserDTO;
import com.blogger.bloggingapp.users.dto.UserResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserResponseDTO createUser(CreateUserDTO createUserDTO){
         var userEntity=modelMapper.map(createUserDTO,UserEntity.class);
         var savedUser=userRepository.save(userEntity);
         var userResponseDTO= modelMapper.map(savedUser,UserResponseDTO.class);
        return userResponseDTO;
    }

    public UserResponseDTO loginUser(LoginUserDTO loginUserDTO){
        var loginUser=userRepository.findByUsername(loginUserDTO.getUsername());
        if(loginUser==null){
            throw new UserNotFoundException(loginUserDTO.getUsername());
        }

        if(!loginUser.getPassword().equals(loginUserDTO.getPassword())){
            throw new IncorrectPasswordException(loginUserDTO.getUsername());
        }

        var userResponseDTO=modelMapper.map(loginUser,UserResponseDTO.class);
        return userResponseDTO;
    }

    public List<UserResponseDTO> getAllUsers(){
        List<UserEntity> allUsers=userRepository.findAll();
        List<UserResponseDTO> listAllUsers=new ArrayList<>();
        for(UserEntity user:allUsers){
            var userDTO=modelMapper.map(user,UserResponseDTO.class);
            listAllUsers.add(userDTO);
        }
        return  listAllUsers;
    }

    public static class UserNotFoundException extends IllegalArgumentException{
        public UserNotFoundException(Integer id){
            super("User with id " + id + "not found");
        }

        public UserNotFoundException(String username){
            super("User with username " + username + "not found");
        }
    }

    public static class IncorrectPasswordException extends IllegalArgumentException{
        public IncorrectPasswordException(String username){
            super("User with username " + username + "has incorrect password");
        }
    }


}
