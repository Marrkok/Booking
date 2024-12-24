package com.OnlineBooking.OnlineBooking.Controller;

import com.OnlineBooking.OnlineBooking.Model.User;
import com.OnlineBooking.OnlineBooking.Service.UserService;
import org.apache.coyote.Response;
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
            String check= userService.login(loginRequest);
            if (check.contains("failed")) {
                return ResponseEntity.status(401).body("Invalid email or password");
            }
            else if (check.contains("already")) {
                return ResponseEntity.status(401).body(" A User is already logged in ");
            }
            return ResponseEntity.ok("Login successful");}
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(500).body("Error during login: "+e.getMessage());
        }
    }
    @PostMapping("/register")
    public ResponseEntity<String> Register(@RequestBody User reginfo)
    {
        try {
            if(userService.register(reginfo))
            {
                return ResponseEntity.ok("User registered successfully");
            }
            else
            {
                return ResponseEntity.status(401).body("email already exists");
            }
        }
        catch (Exception e){

            String message="error registering user"+e.getMessage() ;
            return ResponseEntity.status(500).body(message);
        }
    }
    @PostMapping("/user/logout")
    public void logout(){
        userService.logout();
    }
    @GetMapping("/getem")
    public ArrayList getUsers(){
        return User.users;
    }
}