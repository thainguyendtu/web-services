package com.fpt.webservicesudemy.user;

import com.fpt.webservicesudemy.dto.CreateUserDTO;
import com.fpt.webservicesudemy.dto.UserResponseDTO;
import com.fpt.webservicesudemy.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserResponseDTO> retrieveAllUsers() {
        List<User> usersList = userRepository.findByDelFlagFalse();
        if (CollectionUtils.isEmpty(usersList)) {
            return new ArrayList<>();
        }
        return usersList.stream()
                .map(user -> UserResponseDTO.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .birthDate(user.getBirthDate())
                        .build())
                .toList();
    }

    @Override
    public UserResponseDTO retrieveUser(Integer id) {
        Optional<User> userOptional = userRepository.findUserOptionalByIdAndDelFlagFalse(id);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("User not found for id: " + id);
        }
        return UserResponseDTO.builder()
                .id(userOptional.get().getId())
                .name(userOptional.get().getName())
                .birthDate(userOptional.get().getBirthDate())
                .build();
    }

    @Override
    public User addUser(CreateUserDTO dto) {
        User userToAdd = new User();
        userToAdd.setName(dto.getName());
        userToAdd.setBirthDate(dto.getBirthDate());
        return userRepository.save(userToAdd);
    }

    @Override
    public void deleteUser(Integer id) {
        Optional<User> userOptional = userRepository.findUserOptionalByIdAndDelFlagFalse(id);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("User not found for id: " + id);
        }
        User user = userOptional.get();
        user.setDelFlag(true);
        userRepository.save(user);
    }
}
