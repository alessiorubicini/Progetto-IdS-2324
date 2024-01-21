package it.unicam.cs.opencity.service;

import it.unicam.cs.opencity.entity.*;
import it.unicam.cs.opencity.entity.publisher.AuthorizedContributorPublisher;
import it.unicam.cs.opencity.entity.publisher.ContributorPublisher;
import it.unicam.cs.opencity.repository.CityRepository;
import it.unicam.cs.opencity.repository.ContentRepository;
import it.unicam.cs.opencity.repository.FavoriteRepository;
import it.unicam.cs.opencity.repository.ParticipationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.List;

@Service
public class ContentService {

    private final FavoriteRepository favoriteRepository;
    private final CityRepository cityRepository;
    private final ContentRepository contentRepository;
    private final ParticipationRepository participationRepository;
    private final ContributorPublisher contributorPublisher;
    private final AuthorizedContributorPublisher authorizedcontributorPublisher;

    @Autowired
    public ContentService(FavoriteRepository favoriteRepository, CityRepository cityRepository, ContentRepository contentRepository, ParticipationRepository participationRepository, ContributorPublisher contributorPublisher, AuthorizedContributorPublisher authorizedcontributorPublisher) {
        this.favoriteRepository = favoriteRepository;
        this.cityRepository = cityRepository;
        this.contentRepository = contentRepository;
        this.participationRepository = participationRepository;
        this.contributorPublisher = contributorPublisher;
        this.authorizedcontributorPublisher = authorizedcontributorPublisher;
    }

    public List<Content> getContentsOfPoint(Integer pointId, Integer cityId) {
        if (cityRepository.findById(cityId).isPresent()) {
            City city = cityRepository.findById(cityId).get();
            Point point = city.getPoint(pointId);
            return point.getContents();
        } else {
            return null;
        }
    }

    public Content getContentDetails(Integer contentId, Integer pointId, Integer cityId) {
        if (cityRepository.findById(cityId).isPresent()) {
            City city = cityRepository.findById(cityId).get();
            Point point = city.getPoint(pointId);
            return point.getContent(contentId);
        } else {
            return null;
        }
    }

    @Transactional
    public boolean addContent(Content content, Integer pointId, Integer cityId) {
        Integer userId = content.getAuthorId();
        Participation participation = participationRepository.findByIdUserIdAndIdCityId(userId, cityId).get(0);
        ParticipationId participationId = participation.getId();
        Role role = participationId.getRole();

        if(Objects.equals(role.getTitle(), "Contributor"))
            this.contributorPublisher.publish(content, pointId, cityId);
        else if(Objects.equals(role.getTitle(), "Authorized Contributor"))
            this.authorizedcontributorPublisher.publish(content, pointId, cityId);
        return true;
    }

    @Transactional
    public boolean deleteContent(Integer contentId, Integer pointId, Integer cityId) {
        this.contentRepository.deleteById(contentId);
        return true;
        /*if (cityRepository.findById(cityId).isPresent()) {
            City city = cityRepository.findById(cityId).get();
            Point point = city.getPoint(pointId);
            point.removeContent(contentId);
            cityRepository.save(city);
            return true;
        } else {
            return false;
        }*/
    }

    public boolean addFavorite(Favorite favorite){
        favoriteRepository.save(favorite);
        return true;
    }

    public boolean removeFavorite(Favorite favorite)
    {
        favoriteRepository.delete(favorite);
        return true;
    }

}
