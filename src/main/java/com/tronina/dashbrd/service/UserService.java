package com.tronina.dashbrd.service;

import com.tronina.dashbrd.entity.User;
import com.tronina.dashbrd.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User, UserRepository> {

    public UserService(UserRepository repository) {
        super(repository);
    }
}
