package com.dreamjournal.backendapi.service;

import com.dreamjournal.backendapi.entity.User;
import com.dreamjournal.backendapi.model.response.ApiResponse;
import com.dreamjournal.backendapi.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ApiResponse validateUser(User userRequest) {
        if (StringUtils.isAnyEmpty(userRequest.getName(), userRequest.getPassword())) {
            return new ApiResponse(false, "The registration request was not valid, please try again.");
        }

        if (userRepository.existsByName(userRequest.getName())) {
            return new ApiResponse(false, "The given name is already in use!");
        }

        return new ApiResponse(true);
    }

    public Boolean doesUserExist(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);

        return userOptional.isPresent();
    }

    public Boolean doesUserExistWithName(String name) {
        User user = userRepository.findByName(name);

        if (user != null)
            return true;

        return false;
    }
}
