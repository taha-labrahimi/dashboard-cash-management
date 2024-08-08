package com.sorec.dashboardcashmanagement.repository;

import com.sorec.dashboardcashmanagement.dto.UserDTO;
import com.sorec.dashboardcashmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
