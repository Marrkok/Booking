package com.OnlineBooking.OnlineBooking.Controller;

import com.OnlineBooking.OnlineBooking.Model.User;
import com.OnlineBooking.OnlineBooking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.awt.*;
import java.util.ArrayList;

@RestController
//@RequestMapping("/api/users")
public class UserController
{
    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginRequest) {
       try{ String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        User user = User.findByEmail(email);
        if (user == null || !user.getPassword().equals(password)) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }

        return ResponseEntity.ok("Login successful");}
       catch (Exception e) {
           System.out.println(e.getMessage());
           return null;
       }
    }
    @PostMapping("/register")
    public boolean Register(@RequestBody User reginfo)
    {
        try {return userService.register(reginfo);}
        catch (Exception e){
            System.out.println("error registering user"+e.getMessage());
            return false;
        }
    }
    @GetMapping("/getem")
    public ArrayList getusers(){
        return User.users;
    }
}