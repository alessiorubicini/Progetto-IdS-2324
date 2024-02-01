package it.unicam.cs.opencity.entity.publisher;

import it.unicam.cs.opencity.entity.City;
import it.unicam.cs.opencity.entity.Content;
import it.unicam.cs.opencity.entity.ContentStatus;
import it.unicam.cs.opencity.entity.Point;
import it.unicam.cs.opencity.repository.CityRepository;
import it.unicam.cs.opencity.util.NotificationComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ContributorPublisher extends ContentPublisher{

    private final NotificationComponent notificationComponent;
    private final CityRepository cityRepository;

    @Autowired
    public ContributorPublisher(NotificationComponent notificationComponent, CityRepository cityRepository) {
        this.notificationComponent = notificationComponent;
        this.cityRepository = cityRepository;
    }

    @Override
    public void sendContent(Content content, Integer pointId, Integer cityId) {
        Optional<City> city = cityRepository.findById(cityId);
        if (cityRepository.findById(cityId).isPresent()) {
            Point point = city.get().getPoint(pointId);
            content.setStatus(ContentStatus.Pending);
            point.setCityId(cityId);
            point.addContent(content);
            cityRepository.save(city.get());
        }
    }

    @Override
    public void notifyResponsible() {
        String notificationMessage = "New publication: maragnao";
        String destination = "/send-messages/city/" + cityId;
        notificationComponent.sendNotification(destination, notificationMessage);
    }
}
