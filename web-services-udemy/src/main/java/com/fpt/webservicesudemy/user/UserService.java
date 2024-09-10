package com.fpt.webservicesudemy.user;

import com.fpt.webservicesudemy.dto.CreateUserDTO;
import com.fpt.webservicesudemy.dto.UserResponseDTO;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> retrieveAllUsers();

    UserResponseDTO retrieveUser(Integer id);

    User addUser(CreateUserDTO createUserDTO);

    void deleteUser(Integer id);
}
