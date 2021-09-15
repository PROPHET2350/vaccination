package com.challenge.vaccination.Controllers;

import com.challenge.vaccination.Models.Users;
import com.challenge.vaccination.Services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UsersController {

    @Autowired
    private final UsersServices usersServices;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UsersController(UsersServices usersServices, PasswordEncoder passwordEncoder) {
        this.usersServices = usersServices;
        this.passwordEncoder = passwordEncoder;
    }

    @PutMapping("/api/v1/user/update-account")
    public Users UpdateUser(@RequestParam Map<String,String> body){
        Users us = usersServices.searchById(body.get("id"));
        Users NewUser = new Users(us.getUserid(),body.get("username"),
                passwordEncoder.encode(body.get("password")),us.getRole(),us.getEmployee());
        return usersServices.updateUser(NewUser);
    }

    @PostMapping("/api/v1/user/my-account")
    public Users searchMyAccountByEmployeeId(@RequestParam Map<String,String> body){
        return usersServices.searchByEmployeeId(body.get("id"));
    }
}
