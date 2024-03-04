package com.example.userservice.utils;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class AuthorityUtils {
    public static Collection<? extends GrantedAuthority> createAuthoritiesFromString(String rolesString) {
        return Arrays.stream(rolesString.split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}

