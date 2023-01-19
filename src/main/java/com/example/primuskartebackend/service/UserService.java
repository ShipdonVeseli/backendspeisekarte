package com.example.primuskartebackend.service;

import com.example.primuskartebackend.entity.Users;
import com.example.primuskartebackend.repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
@Transactional
public class UserService {
    private UsersRepository usersRepository;

    @Autowired
    public UserService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public boolean checkUserData(Users users){
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(users.getPassword().getBytes(StandardCharsets.UTF_8));
            String encoded = Base64.getEncoder().encodeToString(hash);
            Users dbuser = usersRepository.getUsersByUsername(users.getUsername());
            if(dbuser.getPassword().equals(encoded) && dbuser.getUsername().equals(users.getUsername())){
                return true;
            }else{
                return false;
            }
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }

    public boolean changePwd(Users users) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(users.getPassword().getBytes(StandardCharsets.UTF_8));
            String encoded = Base64.getEncoder().encodeToString(hash);
            Users dbuser = usersRepository.getUsersByUsername(users.getUsername());
            dbuser.setPassword(encoded);
            return true;

        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }
}
