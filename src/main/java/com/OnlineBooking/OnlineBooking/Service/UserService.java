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
    public boolean register(String UserName, String email, String Password,String PhoneNumber, String Gender, String Age)
    {
        user=User.findByEmail(email);
       /* if(user.getPassword().equals(Password))
        {
            System.out.println("the email and password already exist");
            return false;
        }
        */
        //else

            User newUser = new User( UserName,  email,  Password, PhoneNumber,  Gender, Age);
            newUser.AddUser(user);
            System.out.println("Register successful");
            return true;
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