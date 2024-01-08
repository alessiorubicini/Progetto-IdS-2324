package it.unicam.cs.opencity.util;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotificationComponent {

    private final SimpMessagingTemplate messagingTemplate;

    public NotificationComponent(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendNotification(String destination, String message) {
        messagingTemplate.convertAndSend(destination, message);
    }
}
