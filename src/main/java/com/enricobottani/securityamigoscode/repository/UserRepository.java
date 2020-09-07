package com.enricobottani.securityamigoscode.repository;

import com.enricobottani.securityamigoscode.auth.UserImpl;
import com.enricobottani.securityamigoscode.service.UserService;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository {
    Optional<UserImpl> selectApplicationUserByUsername(String username);
}
