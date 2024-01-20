package it.unicam.cs.opencity.entity.publisher;

import it.unicam.cs.opencity.entity.City;
import it.unicam.cs.opencity.entity.Content;
import it.unicam.cs.opencity.entity.ContentStatus;
import it.unicam.cs.opencity.entity.Point;
import it.unicam.cs.opencity.repository.CityRepository;
import it.unicam.cs.opencity.util.NotificationComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        String notificationMessage = "New publication: maragnao";
        String destination = "/send-messages/city/" + cityId;
        notificationComponent.sendNotification(destination, notificationMessage);
    }
}
