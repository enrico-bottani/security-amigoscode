package com.enricobottani.securityamigoscode.repository;

import com.enricobottani.securityamigoscode.auth.UserImpl;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.enricobottani.securityamigoscode.secuirty.UserRole.*;

@Repository("Mock")
public class MockUserRepository implements UserRepository {

    @Override
    public boolean updateApplicationUserByUsername(String username, String token) {
        for (int i = 0; i < applicationUser.size(); i++) {
            UserImpl user = applicationUser.get(i);
            if (user.getUsername().equals(username)) {
                applicationUser.set(i, new UserImpl(user.getUsername(),
                        passwordEncoder.encode(token),
                        user.getAuthorities(),
                        true,
                        true, true, true));
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<UserImpl> selectApplicationUserByUsername(String username) {
        return applicationUser.stream().filter(u -> username.equals(u.getUsername())).findFirst();
    }

    private final List<UserImpl> applicationUser;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MockUserRepository(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        applicationUser = Lists.newArrayList(
                new UserImpl("anna@gmail.com", passwordEncoder.encode("1234"),
                        STUDENT.getGrantedAuthorities(),
                        true, true, true, true),
                new UserImpl("linda@gmail.com", passwordEncoder.encode("1234"),
                        ADMIN.getGrantedAuthorities(),
                        true, true, true, true),
                new UserImpl("tom@gmail.com", passwordEncoder.encode("1234"),
                        ADMIN_TRAINEE.getGrantedAuthorities(),
                        true, true, true, true));
    }
}
