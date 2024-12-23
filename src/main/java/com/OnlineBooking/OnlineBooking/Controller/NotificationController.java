package com.OnlineBooking.OnlineBooking.Controller;

import com.OnlineBooking.OnlineBooking.Model.Notification;
import com.OnlineBooking.OnlineBooking.Model.NotificationTemplate;
import com.OnlineBooking.OnlineBooking.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;


    @PostMapping("/add")
    public String addNotification(@RequestBody Notification notification)
    {
        notificationService.addNotificationToQueue(notification);
        return "Notification added to queue successfully.";
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/send")
    public String sendNotifications()
    {
        notificationService.sendNotifications();
        return "All notifications have been sent.";
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/add-template")
    public String addTemplate(@RequestBody NotificationTemplate template)
    {
        notificationService.addTemplate(template);
        return "Notification template added successfully.";
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/templates/{templateName}")
    public NotificationTemplate getTemplate(@PathVariable String templateName)
    {
        return notificationService.getTemplateByName(templateName);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/queue")
    public List<Notification> getQueue() {
        return notificationService.getNotificationQueue();
    }
}
