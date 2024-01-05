package it.unicam.cs.opencity.controller;


import it.unicam.cs.opencity.entity.Content;
import it.unicam.cs.opencity.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/content")
public class ContentController {

    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Content> uploadContent(@RequestBody Content content) {
        if(contentService.uploadContent(content))
            return new ResponseEntity<>(content, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Content> getContentDetails(@PathVariable Integer id){
        Content content = contentService.getContentDetails(id).orElse(null);
        if(content != null)
            return new ResponseEntity<>(content, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{userId}/contents")
    public ResponseEntity<List<Content>> getContentsOfUser(@PathVariable Integer userId) {
        List<Content> contents = contentService.getContentsOfUser(userId);
        if(contents != null)
            return new ResponseEntity<>(contents, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteContent(@PathVariable Integer id){
        if(contentService.removeContent(id))
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateContent(@PathVariable Integer id, @RequestBody Content content){
        if(contentService.updateContent(id, content))
            return new ResponseEntity<>(content, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
