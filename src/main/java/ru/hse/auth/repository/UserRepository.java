package ru.hse.auth.repository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

public class UserRepository {
    public List<UserDetails> allUsers;

    public UserDetails getUserByName(String name) {
        return allUsers.stream().filter(ud -> name.equals(ud.getUsername())).toList().get(0);
    }
}
