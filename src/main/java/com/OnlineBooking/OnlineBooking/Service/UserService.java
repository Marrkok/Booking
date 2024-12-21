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

    public boolean login(String email, String password)
    {
        user=User.findByEmail(email);
        if(user.getPassword().equals(password))
        {
            System.out.println("sucessfully logged in");
            return true;
        }
        else
        {
            System.out.println("Login failed, please try again");
            return false;
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
    public class UserInitializer {//remove once done

        @PostConstruct
        public void init() {
            if (User.users.isEmpty()) {
                User.users.add(new User("JohnDoe", "john.doe@gmail.com", "1234", "1234567890", "Male", "25"));
                User.users.add(new User("JaneDoe", "jane.doe@gmail.com", "abcd", "0987654321", "Female", "30"));
            }
        }
    }
}

//}