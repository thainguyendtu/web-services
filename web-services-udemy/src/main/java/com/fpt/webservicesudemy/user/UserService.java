package com.fpt.webservicesudemy.user;

import com.fpt.webservicesudemy.dto.UserResponseDTO;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> retrieveAllUsers();

    UserResponseDTO retrieveUser(Integer id);

    User addUser(User user);

    void deleteUser(Integer id);
}
