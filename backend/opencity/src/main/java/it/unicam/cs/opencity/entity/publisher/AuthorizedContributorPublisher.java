package it.unicam.cs.opencity.entity.publisher;

import it.unicam.cs.opencity.entity.City;
import it.unicam.cs.opencity.entity.Content;
import it.unicam.cs.opencity.entity.ContentStatus;
import it.unicam.cs.opencity.entity.Point;
import it.unicam.cs.opencity.repository.CityRepository;
import it.unicam.cs.opencity.repository.ContentRepository;
import it.unicam.cs.opencity.service.ContentService;
import it.unicam.cs.opencity.util.NotificationComponent;
import org.springframework.stereotype.Component;

@Component
public class AuthorizedContributorPublisher extends ContentPublisher {

    private final NotificationComponent notificationComponent;
    private final CityRepository cityRepository;

    public AuthorizedContributorPublisher(NotificationComponent notificationComponent, CityRepository cityRepository) {
        this.notificationComponent = notificationComponent;
        this.cityRepository = cityRepository;
    }

    @Override
    public void sendContent(Content content, Integer pointId, Integer cityId) {
        content.setStatus(ContentStatus.Pending);
        if (cityRepository.findById(cityId).isPresent()) {
            City city = cityRepository.findById(cityId).get();
            Point point = city.getPoint(pointId);
            point.addContent(content);
            cityRepository.save(city);
        }
    }

    @Override
    public void notifyResponsible() {
        String notificationMessage = "New publication: barabimbimbum";
        String destination = "/send-messages/city/" + cityId;
        notificationComponent.sendNotification(destination, notificationMessage);
    }
}
