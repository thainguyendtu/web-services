package com.fpt.web_services_udemy.user;

import java.util.List;

public interface UserService {

    List<User> retrieveAllUsers();

    User retrieveUser(Integer id);

    User addUser(User user);

    void deleteUser(Integer id);
}
