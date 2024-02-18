package com.example.demo.vo;

import org.springframework.security.core.GrantedAuthority;
public enum UserRole implements GrantedAuthority {
    ROLE_ADMIN, ROLE_EMPLOYEE, GUEST;	
    @Override
    public String getAuthority() {
        return name();
    }
}
