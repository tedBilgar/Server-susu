package com.tedbilgar.demo.service;

import com.tedbilgar.demo.DAO.Dao;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private Dao userDao;

    @PostConstruct
    public void init() {
        userDao.findByUserName("user").ifPresent(user -> {
            user.setPassword(new BCryptPasswordEncoder().encode("password"));
            userDao.save(user);
        });
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.findByUserName(username).orElseThrow(() ->
                new UsernameNotFoundException("user" + username + " was not found!"));
    }
}
