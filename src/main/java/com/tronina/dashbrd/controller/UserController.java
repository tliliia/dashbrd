package com.tronina.dashbrd.controller;

import com.tronina.dashbrd.entity.User;
import com.tronina.dashbrd.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends APIController <User, UserService> {

    public UserController(UserService service) {
        super(service);
    }
}
