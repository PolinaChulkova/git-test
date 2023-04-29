package com.example.gistest.service;

import com.example.gistest.dto.RegistrationRequest;
import com.example.gistest.entity.User;
import com.example.gistest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByLogin(username).block();
    }

    public Long getUserIdByUsername(String username) {
        return Objects.requireNonNull(userRepository.findByLogin(username).block()).getId();
    }

    public User registerUser(RegistrationRequest registrationRequest) {
        return userRepository.save(new User(
                registrationRequest.getLogin(),
                passwordEncoder.encode(registrationRequest.getPassword()),
                registrationRequest.getRole())).block();
    }
}
