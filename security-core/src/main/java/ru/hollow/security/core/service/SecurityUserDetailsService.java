package ru.hollow.security.core.service;

public interface SecurityUserDetailsService<T> {


    T getByUsername(String username);
}
