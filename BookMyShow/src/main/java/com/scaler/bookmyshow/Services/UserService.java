package com.scaler.bookmyshow.Services;

import com.scaler.bookmyshow.Models.User;
import com.scaler.bookmyshow.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public User createUser(String username, String password){
        User user = new User(username, password);
        return userRepository.save(user);
    }
}
