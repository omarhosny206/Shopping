package com.bm.service;

import com.bm.dto.LoginResponse;
import com.bm.entity.CustomUserDetails;
import com.bm.entity.User;
import com.bm.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void update(User user) {
        userRepository.save(user);
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public LoginResponse getByEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);

        if (user == null)
            return null;

        LoginResponse loginResponse = new LoginResponse();
        BeanUtils.copyProperties(user, loginResponse);
        return loginResponse;
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = getByEmail(email);
        System.out.println(user);
        return new CustomUserDetails(user);
    }
}
