package com.erickjesus.workshopmongo.services;

import com.erickjesus.workshopmongo.domain.User;
import com.erickjesus.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findALL() {
        return repo.findAll();
    }
}
