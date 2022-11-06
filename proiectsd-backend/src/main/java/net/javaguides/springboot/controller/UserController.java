package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Rol;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.UserService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Component
    public class RolEnumConverter implements Converter<String, Rol> {
        @Override
        public Rol convert(String value) {
            return Rol.valueOf(value);
        }
    }
    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    //build creTE user rest api
    @PostMapping()
    public ResponseEntity<User> user(@RequestBody User user){
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }

    //build get all users rest api
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //build get  users by id rest api
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        return new ResponseEntity<User>(userService.getUserById(id),HttpStatus.OK) ;
    }

    //build update user REST API
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id,
                                           @RequestBody User user) {
        return new ResponseEntity<User>(userService.updateUser(user,id),HttpStatus.OK);

    }
    //delete rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<String>("User succesfully deleted",HttpStatus.OK);

    }





}
