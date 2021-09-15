package com.challenge.vaccination.Services;

import com.challenge.vaccination.Models.Users;
import com.challenge.vaccination.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServices implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    public UsersServices(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    public void CreateUser(Users us){
        this.usersRepository.save(us);
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users us = usersRepository.findByUsername(s);
        List<GrantedAuthority> rol = new ArrayList<>();
        rol.add(new SimpleGrantedAuthority(us.getRole()));
        return new User(us.getUsername(),us.getPassword(),rol);
    }
}
