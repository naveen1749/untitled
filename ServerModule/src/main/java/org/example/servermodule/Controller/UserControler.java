package org.example.servermodule.Controller;

import org.example.servermodule.Models.User;
import org.example.servermodule.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class UserControler {

    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(UserControler.class);

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        Optional<User> optionalUser = userService.getUser(id);
        return optionalUser.orElseGet(null);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        List<User> users = null;
        try {
            users= userService.getUsers();
            logger.info("Users retrieved & size is : " + users.size());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return users;
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        System.out.println(user);
        System.out.println(user.getName());
        User temp = user;
        try {
            temp= userService.addUser(user);
           logger.info("User saved with id " + user.getId());
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return temp;
    }

    @DeleteMapping("/delete/{id}")
    public int saveUser(@PathVariable("id") Long id) {
        try {
             userService.deleteUser(id);
             logger.info("User deleted with id " + id);
             return 0;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return 1;
        }
    }

    @PutMapping("/update")
    public int updateUser(@RequestBody User user) {
        try {
            userService.updateUser(user);
            logger.info("User updated with id " + user.getId());
            return 0;
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return 1;
        }
    }
}
