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
    private static Integer loggedUserId=null;
    public String login(User loginUser)
    {
        user=User.findByEmail(loginUser.getEmail());
        if(loggedUserId!=null){
            System.out.println("A User is logged in already");
            return "A User is logged in already";
        }
        else if(loggedUserId==null&&user.getPassword().equals(loginUser.getPassword())&&user!=null)
        {
            loggedUserId=user.getUserID();
            System.out.println("sucessfully logged in");
            return "successfully logged in";
        }
        else
        {
            System.out.println("Login failed, please try again");
            return "Login failed, please try again";
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
  public void logout(){
        loggedUserId=null;
  }
  public static int getsession(){
        return loggedUserId;
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