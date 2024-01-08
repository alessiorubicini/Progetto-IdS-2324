package it.unicam.cs.opencity.entity.publisher;

import it.unicam.cs.opencity.util.NotificationComponent;
import org.springframework.stereotype.Component;

@Component
public class ContributorPublisher extends ContentPublisher{

    private final NotificationComponent notificationComponent;

    public ContributorPublisher(NotificationComponent notificationComponent) {
        this.notificationComponent = notificationComponent;
    }


    @Override
    public void sendContent() {

    }

    @Override
    public void notifyResponsible(Integer cityId) {
        String notificationMessage = "New publication: ";
        String destination = "/send-messages/city/" + cityId;
        notificationComponent.sendNotification(destination, notificationMessage);
    }
}
