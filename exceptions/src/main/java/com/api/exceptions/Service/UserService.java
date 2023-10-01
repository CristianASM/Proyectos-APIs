package com.api.exceptions.Service;


import com.api.exceptions.Dto.UserDTO;
import com.api.exceptions.Model.User;

import java.util.List;

public interface UserService {
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();

    UserDTO saveUser(User user);
}
