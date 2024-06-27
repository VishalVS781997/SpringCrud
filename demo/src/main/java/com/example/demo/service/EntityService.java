package com.example.demo.service;

import com.example.demo.Repo.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityService {

    @Autowired
    private UserRepositary userRepositary;

}
