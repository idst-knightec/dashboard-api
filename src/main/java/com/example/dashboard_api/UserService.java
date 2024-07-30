package com.example.dashboard_api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(String id) {

        UUID uuid = UUID.fromString(id);
        Optional<User> optionalUser = userRepo.findById(uuid);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }
        log.info("User with id: {} doesn't exist", id);
        return null;
    }

    public User saveUser (User user) {
        User savedUser = userRepo.save(user);

        log.info("User with id: {} saved successfully", user.getId());
        return savedUser;
    }
}
