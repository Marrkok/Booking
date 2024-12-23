package com.OnlineBooking.OnlineBooking.Service;

import com.OnlineBooking.OnlineBooking.Model.Notification;
import com.OnlineBooking.OnlineBooking.Model.NotificationTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {

    private List<Notification> notificationQueue = new ArrayList<>();
    private List<NotificationTemplate> templates = new ArrayList<>();


    public void addNotificationToQueue(Notification notification) {
        notificationQueue.add(notification);
    }


    public void sendNotifications() {
        for (Notification notification : notificationQueue)
        {
            System.out.println("Sending notification to " + notification.getRecipient() + ": " + notification.getMessage());
        }
        notificationQueue.clear();
    }

    public void addTemplate(NotificationTemplate template) {
        templates.add(template);
    }


    public NotificationTemplate getTemplateByName(String templateName) {
        return templates.stream()
                .filter(template -> template.getName().equals(templateName))
                .findFirst()
                .orElse(null); // Return null if template is not found
    }


    public List<Notification> getNotificationQueue() {
        return notificationQueue;
    }
}
