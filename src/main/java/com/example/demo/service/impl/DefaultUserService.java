package com.example.demo.service.impl;

import com.example.demo.dto.User;
import com.example.demo.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.example.demo.config.CacheManagerConfig.USER_CACHE;

@Service
public class DefaultUserService implements UserService {

    @Override
    public List<User> getAllUsers() {
        return getMockUsers();
    }

    @Cacheable(USER_CACHE)
    private List<User> getMockUsers() {
        return IntStream.range(0, 1000).mapToObj(i -> new User(i, UUID.randomUUID().toString(), UUID.randomUUID().toString()))
                .collect(Collectors.toList());
    }
}