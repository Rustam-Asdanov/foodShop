package com.example.foodShop.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.foodShop.security.ApplicationPermission.*;

public enum ApplicationRole {
    ADMIN(Sets.newHashSet(DATA_READ,DATA_EDIT)),
    ADMIN_JUNIOR(Sets.newHashSet(DATA_READ));

    private final Set<ApplicationPermission> rolePermissionList;


    ApplicationRole(Set<ApplicationPermission> rolePermissionList) {
        this.rolePermissionList = rolePermissionList;
    }

    public Set<ApplicationPermission> getRolePermissionList() {
        return rolePermissionList;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> simpleGrantedAuthorities =
                getRolePermissionList().stream().map(
                        applicationPermission -> new SimpleGrantedAuthority(applicationPermission.getPermissionInfo())
                ).collect(Collectors.toSet());
        return simpleGrantedAuthorities;
    }
}
