package it.unicam.cs.opencity.controller;

import it.unicam.cs.opencity.util.NotificationComponent;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    private final NotificationComponent notificationService;

    public MessageController(NotificationComponent notificationService) {
        this.notificationService = notificationService;
    }

    @MessageMapping("/send-message")
    public void sendMessage(String message) {
        String notificationMessage = "Server: " + message;
        String destination = "/messages";
        notificationService.sendNotification(destination, notificationMessage);
        System.out.println("Message sent to " + destination + ": " + notificationMessage);
    }

    @MessageMapping("/send-message/city/{cityId}")
    @SendTo("/messages/city/{cityId}")
    public String sendMessageToCity(@DestinationVariable String cityId, String message) {
        String resultMessage = "Server (City " + cityId + "): " + message;
        System.out.println(resultMessage);
        return resultMessage;
    }
}
