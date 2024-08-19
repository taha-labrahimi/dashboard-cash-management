package com.sorec.dashboardcashmanagement.service;

import com.sorec.dashboardcashmanagement.dto.UserDTO;
import com.sorec.dashboardcashmanagement.mapper.UserMapper;
import com.sorec.dashboardcashmanagement.model.User;
import com.sorec.dashboardcashmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO findByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDto(user);
    }
}
