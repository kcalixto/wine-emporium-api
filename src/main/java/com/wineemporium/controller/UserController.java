package com.wineemporium.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.wineemporium.entity.User;
import com.wineemporium.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        User user = userRepository.findById(id).get();

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }

    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<String> save(@RequestBody User user) {
        try {
            userRepository.save(user);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/save/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody User user) {
        User userToUpdate = userRepository.findById(id).get();

        if (userToUpdate == null) {
            return ResponseEntity.notFound().build();
        }

        // todo validate empty inputs
        userToUpdate.setName(user.getName());
        userToUpdate.setDocument(user.getDocument());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPhoneDomain(user.getPhoneDomain());
        userToUpdate.setPhoneNumber(user.getPhoneNumber());

        userRepository.save(userToUpdate);

        return ResponseEntity.ok().build();

    }

}
