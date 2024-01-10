package it.unicam.cs.opencity.entity.publisher;

import it.unicam.cs.opencity.entity.Content;
import it.unicam.cs.opencity.entity.ContentStatus;
import it.unicam.cs.opencity.service.ContentService;
import it.unicam.cs.opencity.util.NotificationComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContributorPublisher extends ContentPublisher{

    private final NotificationComponent notificationComponent;
    private final ContentService contentService;

    @Autowired
    public ContributorPublisher(NotificationComponent notificationComponent, ContentService contentService) {
        this.notificationComponent = notificationComponent;
        this.contentService = contentService;
    }


    @Override
    public void sendContent(Content content) {
        content.setStatus(ContentStatus.Pending);
        contentService.uploadContent(content, cityId);
    }

    @Override
    public void notifyResponsible() {
        String notificationMessage = "New publication: maragnao";
        String destination = "/send-messages/city/" + cityId;
        notificationComponent.sendNotification(destination, notificationMessage);
    }
}
