package com.fpt.web_services_udemy.user;

import com.fpt.web_services_udemy.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User retrieveUser(Integer id) {
        Optional<User> userOptional = userRepository.findUserOptionalById(id);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("User not found for id: " + id);
        }
        return userOptional.get();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        Optional<User> userOptional = userRepository.findUserOptionalById(id);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("User not found for id: " + id);
        }
        User user = userOptional.get();
        user.setDelFlag(true);
        userRepository.save(user);
    }
}
