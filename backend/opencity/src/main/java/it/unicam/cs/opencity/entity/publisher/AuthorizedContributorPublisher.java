package it.unicam.cs.opencity.entity.publisher;

import it.unicam.cs.opencity.entity.Content;
import it.unicam.cs.opencity.entity.ContentStatus;
import it.unicam.cs.opencity.repository.ContentRepository;
import it.unicam.cs.opencity.service.ContentService;
import it.unicam.cs.opencity.util.NotificationComponent;
import org.springframework.stereotype.Component;

@Component
public class AuthorizedContributorPublisher extends ContentPublisher{

    private final NotificationComponent notificationComponent;
    private final ContentRepository contentRepository;

    public AuthorizedContributorPublisher(NotificationComponent notificationComponent, ContentRepository contentRepository) {
        this.notificationComponent = notificationComponent;
        this.contentRepository = contentRepository;
    }

    @Override
    public void sendContent(Content content) {
        content.setStatus(ContentStatus.Published);
        this.contentRepository.save(content);
    }

    @Override
    public void notifyResponsible() {
        String notificationMessage = "New publication: barabimbimbum";
        String destination = "/send-messages/city/" + cityId;
        notificationComponent.sendNotification(destination, notificationMessage);
    }
}
