package com.api.exceptions.Service;

import com.api.exceptions.Model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> allUsers();
    User userById(Long id);
    User updateUser(Long id, User user);
    void deleteUser(Long id);

}
