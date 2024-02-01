package it.unicam.cs.opencity.entity.publisher;

import it.unicam.cs.opencity.entity.City;
import it.unicam.cs.opencity.entity.Content;
import it.unicam.cs.opencity.entity.ContentStatus;
import it.unicam.cs.opencity.entity.Point;
import it.unicam.cs.opencity.repository.CityRepository;
import it.unicam.cs.opencity.util.NotificationComponent;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

        Optional<City> city = cityRepository.findById(cityId);
        if (cityRepository.findById(cityId).isPresent()) {
            Point point = city.get().getPoint(pointId);
            content.setStatus(ContentStatus.Published);
            point.setCityId(cityId);
            point.addContent(content);
            cityRepository.save(city.get());
        }
    }

    @Override
    public void notifyResponsible() {
        String notificationMessage = "New publication: barabimbimbum";
        String destination = "/send-messages/city/" + cityId;
        notificationComponent.sendNotification(destination, notificationMessage);
    }
}
