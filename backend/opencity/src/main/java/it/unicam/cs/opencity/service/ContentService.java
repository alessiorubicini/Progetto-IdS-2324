package it.unicam.cs.opencity.service;

import it.unicam.cs.opencity.entity.*;
import it.unicam.cs.opencity.entity.publisher.AuthorizedContributorPublisher;
import it.unicam.cs.opencity.entity.publisher.ContributorPublisher;
import it.unicam.cs.opencity.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Objects;
import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    private final FavoriteRepository favoriteRepository;
    private final CityRepository cityRepository;
    private final ContentRepository contentRepository;
    private final ParticipationRepository participationRepository;
    private final ContributorPublisher contributorPublisher;
    private final AuthorizedContributorPublisher authorizedcontributorPublisher;
    private final UserRepository userRepository;

    @Autowired
    public ContentService(FavoriteRepository favoriteRepository, CityRepository cityRepository, ContentRepository contentRepository, ParticipationRepository participationRepository, ContributorPublisher contributorPublisher, AuthorizedContributorPublisher authorizedcontributorPublisher, UserRepository userRepository) {
        this.favoriteRepository = favoriteRepository;
        this.cityRepository = cityRepository;
        this.contentRepository = contentRepository;
        this.participationRepository = participationRepository;
        this.contributorPublisher = contributorPublisher;
        this.authorizedcontributorPublisher = authorizedcontributorPublisher;
        this.userRepository = userRepository;
    }

    public List<Content> getContentsOfPoint(Integer pointId, Integer cityId) {
        Optional<City> city = cityRepository.findById(cityId);
        if (city.isPresent()) {
            Point point = city.get().getPoint(pointId);
            return point.getContents();
        }
        else
            return null;
    }

    public Content getContentDetails(Integer contentId, Integer pointId, Integer cityId) {
        Optional<City> city = cityRepository.findById(cityId);
        if (city.isPresent()) {
            Point point = city.get().getPoint(pointId);
            return point.getContent(contentId);
        }
        else
            return null;
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
    }

    private Favorite buildFavorite(Integer userId, Integer cityId, Integer pointId, Integer contentId){
        Content content = this.cityRepository.findById(cityId).get().getPoint(pointId).getContent(contentId);
        FavoriteId favoriteId = new FavoriteId(userId, content);
        Favorite favorite = new Favorite();
        favorite.setId(favoriteId);
        return favorite;
    }

    public boolean addFavorite(Integer userId, Integer cityId, Integer pointId, Integer contentId){
        Optional<User> user = this.userRepository.findById(userId);
        user.get().addFavorite(this.buildFavorite(userId, cityId, pointId, contentId));
        userRepository.save(user.get());
        return true;
    }

    public boolean removeFavorite(Integer userId, Integer cityId, Integer pointId, Integer contentId)
    {
        favoriteRepository.delete(buildFavorite(userId, cityId, pointId, contentId));
        return true;
    }

}
