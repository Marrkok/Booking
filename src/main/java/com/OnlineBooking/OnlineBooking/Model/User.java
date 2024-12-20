package com.OnlineBooking.OnlineBooking.Model;



import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class User
{
    public static ArrayList<User> users = new ArrayList<>();

    private String UserName;
    private String email;
    private String Password;
    private String PhoneNumber;
    private int userID;
    private String Gender;
    private String Age;

    public User(){};
    public User(String UserName, String email, String Password,String PhoneNumber, String Gender, String Age)
    {
        this.UserName = UserName;
        this.email = email;
        this.Password = Password;
        this.PhoneNumber = PhoneNumber;
        this.Gender = Gender;
        this.Age = Age;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public void AddUser(User user)
    {
        users.add(user);
    }
    public void deleteUser(User user)
    {
        users.remove(user);
    }

    public static User findByEmail(String email)
    {
        for(User user : users)
        {
            if(user.getEmail().equals(email))
            {
                return user;
            }
        }
        return null;
    }
}