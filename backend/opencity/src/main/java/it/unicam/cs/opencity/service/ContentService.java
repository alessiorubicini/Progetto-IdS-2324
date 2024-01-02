package it.unicam.cs.opencity.service;

import it.unicam.cs.opencity.entity.Content;
import it.unicam.cs.opencity.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class ContentService {

    private final ContentRepository contentRepository;

    @Autowired
    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public Optional<Content> getContentDetails(Integer id){
        return contentRepository.findById(id);
    }

    public List<Content> getContentsOfUser(Integer id){
        return contentRepository.findByAuthorId(id);
    }

    public boolean uploadContent(Content content){
        contentRepository.save(content);
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

    public boolean updateContent(Integer id, Content newContent){
        contentRepository.save(newContent);
        return true;
    }

}
