package it.unicam.cs.opencity.service;

import it.unicam.cs.opencity.entity.*;
import it.unicam.cs.opencity.entity.publisher.AuthorizedContributorPublisher;
import it.unicam.cs.opencity.entity.publisher.ContentPublisher;
import it.unicam.cs.opencity.entity.publisher.ContributorPublisher;
import it.unicam.cs.opencity.repository.ContentRepository;
import it.unicam.cs.opencity.repository.FavoriteRepository;
import it.unicam.cs.opencity.repository.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.List;

@Service
public class ContentService {

    private final ContentRepository contentRepository;
    private final FavoriteRepository favoriteRepository;
    private final ParticipationRepository participationRepository;
    private final ContributorPublisher contributorPublisher;
    private final AuthorizedContributorPublisher authorizedcontributorPublisher;

    @Autowired
    public ContentService(ContentRepository contentRepository, FavoriteRepository favoriteRepository, ParticipationRepository participationRepository, ContributorPublisher contributorPublisher, AuthorizedContributorPublisher authorizedcontributorPublisher) {
        this.contentRepository = contentRepository;
        this.favoriteRepository = favoriteRepository;
        this.participationRepository = participationRepository;
        this.contributorPublisher = contributorPublisher;
        this.authorizedcontributorPublisher = authorizedcontributorPublisher;
    }

    public Optional<Content> getContentDetails(Integer id){
        return contentRepository.findById(id);
    }

    public List<Content> getContentsOfUser(Integer id){
        return contentRepository.findByAuthorId(id);
    }

    public List<Content> getContentOfPoint(Integer id){return contentRepository.findByPointId(id);}

    public boolean uploadContent(Content content, Integer cityId){
        Integer userId = content.getAuthorId();
        Participation participation = participationRepository.findByIdUserIdAndIdCityId(userId, cityId).get(0);
        ParticipationId participationId = participation.getId();
        Role role = participationId.getRole();

        if(Objects.equals(role.getTitle(), "Contributor"))
            this.contributorPublisher.publish(content, cityId);
        else if(Objects.equals(role.getTitle(), "Authorized Contributor"))
            this.authorizedcontributorPublisher.publish(content, cityId);
        return true;
    }

    public boolean removeContent(Integer id) {
        if (contentRepository.existsById(id)) {
            contentRepository.deleteById(id);
            return true;
        }
        else
            return false;
    }




    public boolean updateContent(Content newContent){
        contentRepository.save(newContent);
        return true;
    }

    public boolean addFavorite(Favorite favorite){
        favoriteRepository.save(favorite);
        return true;
    }
}
