package com.OnlineBooking.OnlineBooking.Service;

import com.OnlineBooking.OnlineBooking.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
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
}

//}