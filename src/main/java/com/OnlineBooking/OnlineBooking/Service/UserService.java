package com.OnlineBooking.OnlineBooking.Service;

import com.OnlineBooking.OnlineBooking.Model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private User user;

    public boolean login(User loginUser)
    {
        user=User.findByEmail(loginUser.getEmail());
        if( user==null || !user.getPassword().equals(loginUser.getPassword()))
        {
            System.out.println("Login failed, please try again");
            return false;
        }
        else
        {
            System.out.println("sucessfully logged in");
            return true;
        }
    }
    public boolean register(User NU)
    {
        User existing=User.findByEmail(NU.getEmail());
        if(existing!=null)
        {
            System.out.println("the Email already exist");
            return false;
        }
        else{

            User newUser = new User( NU.getUserName(),  NU.getEmail(),  NU.getPassword(), NU.getPhoneNumber(),  NU.getGender(), NU.getAge());
            User.users.add(newUser);
            System.out.println("Register successful");
            return true;}
  }

    @Component
    public class UserInitializer {

        @PostConstruct
        public void init() {
            if (User.users.isEmpty()) {
                User.users.add(new User("Mohamed ", "mohamed@gmail.com", "1234", "1234567890", "Male", "25"));
                User.users.add(new User("JaneDoe", "jane.doe@gmail.com", "abcd", "0987654321", "Female", "30"));
            }
        }
    }
}

//}