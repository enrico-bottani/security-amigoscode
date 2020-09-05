package com.enricobottani.securityamigoscode.secuirty;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.security.Permission;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.enricobottani.securityamigoscode.secuirty.UserPermission.*;

public enum UserRole {

    STUDENT(new HashSet<>()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE)),
    ADMIN_TRAINEE(Sets.newHashSet(COURSE_READ, STUDENT_READ));
    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        var permissions = getPermissions()
                .stream()
                .map((p) -> new SimpleGrantedAuthority(p.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permissions;
    }
}
