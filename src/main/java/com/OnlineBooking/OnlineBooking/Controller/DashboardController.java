package com.OnlineBooking.OnlineBooking.Controller;

import com.OnlineBooking.OnlineBooking.Model.User;
import com.OnlineBooking.OnlineBooking.Model.EventBooking;
import com.OnlineBooking.OnlineBooking.Model.HotelBooking;
import com.OnlineBooking.OnlineBooking.Model.Notification;
import com.OnlineBooking.OnlineBooking.Service.EventBookingService;
import com.OnlineBooking.OnlineBooking.Service.HotelBookingService;
import com.OnlineBooking.OnlineBooking.Service.UserService;
import com.OnlineBooking.OnlineBooking.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private UserService userService;
    @Autowired
    private HotelBookingService hotelBookingService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private EventBookingService eventBookingService;
   @Autowired
    private User myuser;
    @GetMapping("/dashboard")
    public String showDashboard(Model model, @RequestParam("userID") int userID) {
        User user = myuser.findByid(userID);

        List<EventBooking> eventBookings = eventBookingService.getEventBookingsBYID(userID);
        ArrayList<HotelBooking> hotelBookings = hotelBookingService.getHotelBookingsBYID(userID);
        List<Notification> notifications = notificationService.getNotificationsForUser(userID);

        model.addAttribute("user", user);
        model.addAttribute("eventBookings", eventBookings);
        model.addAttribute("hotelBookings", hotelBookings);
        model.addAttribute("notifications", notifications);


        return "dashboard";
    }
}
