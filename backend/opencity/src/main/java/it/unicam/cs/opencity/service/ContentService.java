package it.unicam.cs.opencity.service;

import it.unicam.cs.opencity.entity.Content;
import it.unicam.cs.opencity.entity.Favorite;
import it.unicam.cs.opencity.entity.publisher.ContentPublisher;
import it.unicam.cs.opencity.repository.ContentRepository;
import it.unicam.cs.opencity.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class ContentService {

    private final ContentRepository contentRepository;
    private final FavoriteRepository favoriteRepository;
    private final ContentPublisher contentPublisher;

    @Autowired
    public ContentService(ContentRepository contentRepository, FavoriteRepository favoriteRepository, ContentPublisher contentPublisher) {
        this.contentRepository = contentRepository;
        this.favoriteRepository = favoriteRepository;
        this.contentPublisher = contentPublisher;
    }

    public Optional<Content> getContentDetails(Integer id){
        return contentRepository.findById(id);
    }

    public List<Content> getContentsOfUser(Integer id){
        return contentRepository.findByAuthorId(id);
    }

    public List<Content> getContentOfPoint(Integer id){return contentRepository.findByPointId(id);}

    public boolean uploadContent(Content content, Integer cityId){
        contentPublisher.publish(content, cityId);
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
