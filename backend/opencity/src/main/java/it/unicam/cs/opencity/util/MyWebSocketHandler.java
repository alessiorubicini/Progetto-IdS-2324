package it.unicam.cs.opencity.util;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Controller
public class MyWebSocketHandler {

    @MessageMapping("/hello")
    @SendTo("/messages/greetings")
    public String greeting(String message) throws Exception {
        return "Hello from server to " + message;
    }

}