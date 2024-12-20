package com.OnlineBooking.OnlineBooking.Controller;

import com.OnlineBooking.OnlineBooking.Model.User;
import com.OnlineBooking.OnlineBooking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/users")
public class UserController
{
    @Autowired
    private UserService userService;
    @Autowired
    private User user;

    @PostMapping("/login")
    public boolean login(String email, String password)
    {
        return userService.login(email,password);
    }

    @PostMapping("/register")
    public boolean Register(String UserName, String email, String Password,String PhoneNumber, String Gender, String Age)
    {
        return userService.register(UserName,email,Password,PhoneNumber,Gender,Age);
    }
}