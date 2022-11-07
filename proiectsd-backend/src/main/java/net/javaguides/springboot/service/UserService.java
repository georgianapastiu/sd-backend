package net.javaguides.springboot.service;

import net.javaguides.springboot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUsers();

    User getUserById(Long id);

    User updateUser(User user,Long id);

    void deleteUser(Long id);

}
