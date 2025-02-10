package org.example.servermodule.Service;

import jakarta.transaction.Transactional;
import org.example.servermodule.Models.User;
import org.example.servermodule.Repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    userRepo userRepo;


    public Optional<User> getUser(Long id) {
        try {
            if(id == null) {
                throw new IllegalArgumentException("id is null");
            }
            return userRepo.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User addUser(User user) {
        if(user == null) {
            return user;
        }
        return userRepo.save(user);
    }

   //add update service

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    public int updateUser(User user) {
        if(user.getId() == null) {
            return 0;
        }
        return userRepo.findByUser(user.getId(),user.getName(),user.getPhno(),user.getEmail());
    }
}
