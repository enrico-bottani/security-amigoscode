package com.enricobottani.securityamigoscode.secuirty;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

import static com.enricobottani.securityamigoscode.secuirty.UserPermission.*;

public enum UserRole {

    STUDENT(new HashSet<>()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE));
    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions){
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }
}
