package com.api.exceptions.Service;

import com.api.exceptions.Exceptions.EmptyListException;
import com.api.exceptions.Exceptions.UserNotFoundException;
import com.api.exceptions.Model.User;
import com.api.exceptions.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> allUsers() {
        List<User> users = userRepository.findAll();
        if(users.isEmpty()){
            throw new EmptyListException("Lista de usuarios vacia");
        }
        return users;
    }

    @Override
    public User userById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("Usuario no encontrado"));
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> findUserById = userRepository.findById(id);
        if (findUserById.isPresent()){
            User existingUser = findUserById.get();
            existingUser.setName(user.getName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setGender(user.getGender());
            return userRepository.save(existingUser);
        } else {
            throw new UserNotFoundException("Usuario no encontrado");
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("Usuario no encontrado"));
        userRepository.deleteById(id);
    }
}
