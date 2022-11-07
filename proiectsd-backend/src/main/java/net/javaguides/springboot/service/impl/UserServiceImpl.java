package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository){

        this.userRepository=userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {

        return userRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("User","Id",id));
    }

    @Override
    public User updateUser(User user, Long id) {
        User user_to_update=userRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("User","Id",id));

        user_to_update.setName(user.getName());
        user_to_update.setUsername(user.getUsername());
        user_to_update.setRol(user.getRol());
        user_to_update.setDevice(user.getDevice());
        userRepository.save(user_to_update);
        return user_to_update;

    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User", "Id", id));
        userRepository.deleteById(id);
    }


}
